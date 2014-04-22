package com.example.rhinoCtmButton;

import android.app.Activity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.LinearLayout;
import org.apache.http.util.EncodingUtils;
import org.mozilla.javascript.*;
import org.mozilla.javascript.Context;

import java.io.*;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        dynamic layout
//        setContentView(R.layout.main);

        /** for test */
//        btn = new Button(this);
//        btn.setText("MyActivity: btn");
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int i = 0;
//                Date dt = new Date();
//                // test time
//
//                for (i = 0; i < 100000; i++) {
//                    btn.setText("aaaa" + dt);
//                }
//
//                long sd = new Date().getTime() - dt.getTime();
//                btn.setText("aaaa" + sd);
//
//            }
//        });

//        LinearLayout ll = new LinearLayout(this);
//        ll.addView(btn);

        /** set up the js run environment */
        RunJSMachine runJSMachine = new RunJSMachine();

//        System.out.println("************** path **************");
//        System.out.println(this.getPackageResourcePath());
//        System.out.println(this.getPackageCodePath());
//        System.out.println(CtmClass.class.getName());
//        System.out.println("************** path **************");

        /** readJSFile as a string */
        String jsStr = "";
        try {
            /** read .js file in assets */
            // .js mustn't be larger than 1 M.
            // when deployment into Android
            // .js' files must me read from assets.
            InputStream in = getResources().getAssets().open("GUI.js");
            int length = in.available();
            byte[] buffer = new byte[length];

            in.read(buffer);
            in.close();

            jsStr = EncodingUtils.getString(buffer, "UTF-8");

        } catch (IOException e) {
            System.out.println(e.toString());
        }

        System.out.println("************** Result **************");

        // enter the rhino's context
        Context rhino = Context.enter();
        // needed not to be optimized
        rhino.setOptimizationLevel(-1);
        try {
            Scriptable scope = rhino.initStandardObjects();

            /** put all properties in scope */
//            andStr? but OK here
//            ScriptableObject.putProperty(scope, "anyStr", Context.javaToJS(this.getClassLoader(), scope));
//            add others bellow
            ScriptableObject.putProperty(scope, "ApplicationContext", Context.javaToJS(ContextApplication.class.getClassLoader(), scope));

            // rhino? anyName? : anyName is okay
            rhino.evaluateString(scope, jsStr, "rhino", 1, null);
            // call the .js func "CreateGUI()"
            Function function = (Function) scope.get("CreateGUI", scope);
            // obtain the result
            Object result = function.call(rhino, scope, scope, new String[]{});

            if (result instanceof NativeJavaObject) {
                // get the linear layout from .js file
                // cast is a must
                LinearLayout linearGUI = (LinearLayout) Context.jsToJava(result, LinearLayout.class);

                // set content view
                setContentView(linearGUI);
            }
        } finally {
            Context.exit();
        }
    }
}
