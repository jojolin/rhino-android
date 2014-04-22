package com.example.rhinoCtmButton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import org.apache.http.util.EncodingUtils;

import java.io.IOException;
import java.io.InputStream;

public class ContextActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//
//        Button btn = (Button) findViewById(R.id.btn_js);
//        /** set up the js run environment */
//        RunJSMachine runJSMachine = new RunJSMachine();
//        /** readJSFile as a string */

    }

    public void outPutStr() {
        System.out.println("------ContextActivity------");
    }

}
