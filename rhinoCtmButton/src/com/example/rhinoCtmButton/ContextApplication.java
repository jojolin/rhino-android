package com.example.rhinoCtmButton;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.widget.Button;

public class ContextApplication extends Application {

    private static ContextApplication instance;

    public static ContextApplication Init() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
