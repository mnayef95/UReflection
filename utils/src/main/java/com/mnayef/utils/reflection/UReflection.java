package com.mnayef.utils.reflection;

import android.content.Context;

import java.lang.reflect.Constructor;

/**
 * Created by Mohamed Hamdan on 2017-Jun-09.
 * mohamed.nayef95@gmail.com
 */
public class UReflection {

    private static UReflection mInstance;
    private UReflectionContext mContext;

    private static synchronized UReflection getInstance() {
        return mInstance;
    }

    private UReflection(Context context) {
        this.mContext = new UReflectionContext(context.getApplicationContext());
    }

    private Context getContext() {
        return mContext.getContext();
    }

    public static void init(Context context) {
        if (mInstance == null) {
            mInstance = new UReflection(context);
        }
    }

    public static void bind(Object object, String... fieldsNames) {
        if (fieldsNames.length > 0) {
            for (String fieldName : fieldsNames) {
                bindField(object, fieldName);
            }
        } else {
            bindField(object, "");
        }
    }

    private static void bindField(Object object, String fieldName) {
        Class<?> targetClass = object.getClass();
        String clsName = targetClass.getName();
        try {
            Class<?> bindingClass = targetClass.getClassLoader().loadClass(clsName + "Utils");
            Constructor constructor = bindingClass.getConstructor(targetClass, Context.class, String.class);
            if (constructor != null) {
                constructor.newInstance(object, getInstance().getContext(), fieldName);
            }
        } catch (ClassNotFoundException ignored) {

        } catch (Exception ignored) {
            throw new RuntimeException(ignored);
        }
    }
}
