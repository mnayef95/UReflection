package com.mnayef.compiler;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.annotation.processing.Filer;
import javax.lang.model.element.Modifier;

/**
 * Created by Mohamed Hamdan on 2017-Jun-09.
 * mohamed.nayef95@gmail.com
 */
class TypeHelper {

    private static final ClassName CONTEXT = ClassName.get("android.content", "Context");
    private static final ClassName UI_THREAD = ClassName.get("android.support.annotation", "UiThread");

    private String pkg;
    private Filer filer;

    private TypeSpec.Builder typBuilder;
    private MethodSpec.Builder constructorBuilder;

    TypeHelper(Filer filer, String pkg, String parentCls, String className) {
        this.pkg = pkg;
        this.filer = filer;
        typBuilder = TypeSpec.classBuilder(className).addModifiers(Modifier.PUBLIC);

        constructorBuilder = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addAnnotation(UI_THREAD)
                .addParameter(ClassName.get(pkg, parentCls), "parent")
                .addParameter(CONTEXT, "context")
                .addParameter(String.class, "fieldName");
    }

    void addStatement(String name, Annotation annotation) {
        BindingFactory.bind(constructorBuilder, name, annotation);
    }

    void build() {
        typBuilder.addMethod(constructorBuilder.build()).build();
        JavaFile javaFile = JavaFile.builder(pkg, typBuilder.build()).build();
        try {
            javaFile.writeTo(filer);
        } catch (IOException ignored) {
        }
    }
}
