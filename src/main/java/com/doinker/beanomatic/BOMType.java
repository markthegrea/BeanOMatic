package com.doinker.beanomatic;

import java.util.Date;

public enum BOMType {

    INTEGER(Integer.class, 42), DOUBLE(Double.class, 42.2),
    STRING(String.class, "_string"),
    DATE(Date.class, "2021-02-17 20:27:33")
    
    
    ;

    public Object defaultValue;
    public Class<?> clazz;

    BOMType(Class<?> clazz, Object value) {
        this.clazz = clazz;
        this.defaultValue = value;
    }

}
