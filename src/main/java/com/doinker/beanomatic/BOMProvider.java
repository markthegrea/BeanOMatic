package com.doinker.beanomatic;

public interface BOMProvider <T>{

    T fetchValue(String name);
    
}
