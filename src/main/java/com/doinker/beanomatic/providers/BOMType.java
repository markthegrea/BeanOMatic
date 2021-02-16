package com.doinker.beanomatic.providers;

public enum BOMType {

    INTEGER(42), DOUBLE(42.2), STRING("_string");

    public Object defaultValue;

    BOMType(Object value) {
        this.defaultValue = value;
    }

}
