package com.mnayef.utils.reflection;

import android.content.Context;

/**
 * Created by Mohamed Hamdan on 2017-Jun-09.
 * mohamed.nayef95@gmail.com
 */
class UReflectionContext {

    private Context context;

    UReflectionContext(Context context) {
        this.context = context;
    }

    Context getContext() {
        return context;
    }
}
