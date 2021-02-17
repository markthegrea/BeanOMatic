package com.doinker.beanomatic.providers;

import com.doinker.beanomatic.BOMProvider;
import com.doinker.beanomatic.BOMType;

public class DefaultStringProvider implements BOMProvider<String> {

    @Override
    public String fetchValue(String name) {
        return name + BOMType.STRING.defaultValue;
    }
}
