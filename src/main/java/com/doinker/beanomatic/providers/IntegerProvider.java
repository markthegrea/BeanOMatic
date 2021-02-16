package com.doinker.beanomatic.providers;

public class IntegerProvider implements BOMProvider<Integer> {

    @Override
    public Integer fetchValue(BOMType type) {
        return (Integer) type.defaultValue;
    }
}
