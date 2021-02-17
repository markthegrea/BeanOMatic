package com.doinker.beanomatic.providers;

import com.doinker.beanomatic.BOMProvider;
import com.doinker.beanomatic.BOMType;

public class DefaultIntegerProvider implements BOMProvider<Integer> {

    @Override
    public Integer fetchValue(String name) {
        return (Integer) BOMType.INTEGER.defaultValue;
    }
}
