package com.doinker.beanomatic.providers;

public interface BOMProvider <T>{

    T fetchValue(BOMType type);
    
}
