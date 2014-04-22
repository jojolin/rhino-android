package com.example.rhinoCtmButton;

/**
 * Created by JOJO on 14-4-12.
 * this class:
 *  show how to read .js' file and run them
 */

public class HelloRhino {

    public static void main(String[] args) {

        /** set up the js run environment */
        RunJSMachine runJSMachine = new RunJSMachine();

        /** readJSFile as a string */
        String jsStr = runJSMachine.readJSFile("src/hello/rhino/CallJavaClass.js");
//            System.out.println(jsStr);

        String GUIStr = runJSMachine.readJSFile("src/hello/rhino/GUI.js");
//        System.out.println(GUIStr);

        String SAStr = runJSMachine.readJSFile("src/hello/rhino/SwingApplication.js");
//        System.out.println(SAStr);

        System.out.println("************** Result **************");

        /**
         * "Test" .et are .js' functions in .js' file
         */
        System.out.println(runJSMachine.runScript(jsStr, "Test", new String[]{}));
        System.out.println(runJSMachine.runScript(GUIStr, "createComponents", new String[]{}));
        System.out.println(runJSMachine.runScript(SAStr, "createComponents", new String[]{}));

    }

    // name: --format:$(packageName).$(className) --ex:"hello.rhino.JavaClassProvider"
/*
    private static final String JS_CALL_JAVA_FUNCTION = //
            "var ScriptAPI = java.lang.Class.forName(\"" + "hello.rhino.JavaClassProvider" + "\", true, javaClassProviderLoader);" + //
                    "var methodRead = ScriptAPI.getMethod(\"jsCallJava\", [java.lang.String]);" + //
                    "function jsCallJava(url) {return methodRead.invoke(null, url);}" + //
                    "function Test(){ return jsCallJava(); }";
*/

  /*  private static final String JS_CALL_JAVA_FUNCTION = //
            "var ScriptAPI = java.lang.Class.forName(\"" + JavaClassProvider.class.getName() + "\", true, javaClassProviderLoader);" + //
                    "var methodRead = ScriptAPI.getMethod(\"jsCallJava\", [java.lang.String]);" + //
                    "function jsCallJava(url) {return methodRead.invoke(null, url);}" + //
                    "function Test(){ return jsCallJava(); }";*/

}

