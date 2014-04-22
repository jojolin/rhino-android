package com.example.ctm.widgets;

import android.app.Activity;
import android.content.Context;
import android.widget.Button;
import com.example.rhinoCtmButton.ContextActivity;
import com.example.rhinoCtmButton.ContextApplication;
import com.example.rhinoCtmButton.MyActivity;

/**
 * Created by JOJO on 14-4-12.
 * this class:
 *  define a custom "ctmButton"
 */


public class CtmClass {
    private static String mLabel = "";
    Button btn;


    public CtmClass(String label) {
//        String label = "label";
        btn = new Button(ContextApplication.Init());

        mLabel = label;

    }

    public static String getLabel() {
        return mLabel;
//        return "label xxxx";
    }


// todo:

}
