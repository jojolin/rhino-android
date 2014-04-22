package com.example.rhinoCtmButton;

/**
 * Created by JOJO on 14-4-12.
 * this class:
 */

import org.mozilla.javascript.*;
import org.mozilla.javascript.Context;
import com.example.ctm.widgets.*;

import java.io.*;

public class RunJSMachine {

    /** js调用Java中的方法
     */
//    private static final String JS_CALL_JAVA_FUNCTION = //
//            "var ScriptAPI = java.lang.Class.forName(\"" + RunJSMachine.class.getName() + "\", true, javaLoader);" + //
//                    "var methodRead = ScriptAPI.getMethod(\"jsCallJava\", [java.lang.String]);" + //
//                    "function jsCallJava(url) {return methodRead.invoke(null, url);}" + //
//                    "function Test(){ return jsCallJava(); }";

    /**
     * 执行 js file
     *
     * @param jsString
     * @param functionName js方法名称
     * @param functionParams js方法参数
     * @return
     */
    public String runScript(String jsString, String functionName, Object[] functionParams) {


        Context rhino = Context.enter();
        rhino.setOptimizationLevel(-1);
        try {
            Scriptable scope = rhino.initStandardObjects();

            // todo: put all properties in scope
            // todo: why "javaContext"
            ScriptableObject.putProperty(scope, "javaContext", Context.javaToJS(JavaClassProvider.class, scope));
            ScriptableObject.putProperty(scope, "javaClassProviderLoader", Context.javaToJS(JavaClassProvider.class.getClassLoader(), scope));
            ScriptableObject.putProperty(scope, "CtmClassLoader", Context.javaToJS(CtmClass.class.getClassLoader(), scope));
            ScriptableObject.putProperty(scope, "ContextActivityLoader", Context.javaToJS(ContextActivity.class.getClassLoader(), scope));
            // todo: add others here ..

            // rhino? anyName? : anyName is okay
            rhino.evaluateString(scope, jsString, "rhino", 1, null);
            Function function = (Function) scope.get(functionName, scope);

            Object result = function.call(rhino, scope, scope, functionParams);

            if (result instanceof String) {
                return (String) result;
            } else if (result instanceof NativeJavaObject) {
                return (String) ((NativeJavaObject) result).getDefaultValue(String.class);
            } else if (result instanceof NativeObject) {
                return (String) ((NativeObject) result).getDefaultValue(String.class);
            }

            return result.toString();  //(String) function.call(rhino, scope, scope, functionParams);
        } finally {
            Context.exit();
        }
    }

    /**
     * read .js file as a String
     * @param jsFilePath
     * @return String
     */
    public String readJSFile(String jsFilePath) {
        String jsStr = "";
        try {

            /** resolve path */
            // default dir= "path to rhino_try_1"
            // not "/src/.."
//                FileReader fr = new FileReader("src/hello/rhino/HelloRhino.js");
//                // read file
//                int ch = 0;
//                while ((ch = fr.read()) != -1) {
//                    System.out.print((char) ch);
//                }

            // file path: "src/hello/rhino/HelloRhino.js"
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(jsFilePath)));
            String data = null;

            while ((data = br.readLine()) != null) {
                jsStr += data + "\n";     // "\n" is necessary for the .js comment tag " //comment here .. "
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.toString());

        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return jsStr;
    }


}

