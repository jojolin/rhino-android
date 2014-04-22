/* -*- Mode: java; tab-width: 8; indent-tabs-mode: nil; c-basic-offset: 4 -*-
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */
package com.example.rhinoCtmButton;

public class JavaClassProvider {
    private static final long serialVersionUID = 438270592527335642L;

    // The zero-argument constructor used by Rhino runtime to create instances
    public JavaClassProvider() { }

    public static String jsCallJava(String url) {

        return "农民伯伯 js call Java Rhino " + url;
    }
}
