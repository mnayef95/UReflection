package com.mnayef.compiler;

import java.lang.annotation.Annotation;

/**
 * Created by Mohamed Hamdan on 2017-Jun-09.
 * mohamed.nayef95@gmail.com
 */
class FieldData {

    private String pkgName;
    private String className;
    private String name;
    private Annotation type;

    String getPkgName() {
        return pkgName;
    }

    void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    String getClassName() {
        return className;
    }

    void setClassName(String className) {
        this.className = className;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    void setType(Annotation type) {
        this.type = type;
    }

    Annotation getType() {
        return type;
    }
}
