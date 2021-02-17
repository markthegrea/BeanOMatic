package com.doinker.beanomatic.providers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.doinker.beanomatic.BOMProvider;

public class DedfaultBOMProviderFactory {

    private Map<Class<?>, BOMProvider<?>> providers = new HashMap<>();

    public DedfaultBOMProviderFactory() {
        providers.put(Integer.class, new DefaultIntegerProvider());
        providers.put(int.class, new DefaultIntegerProvider());
        providers.put(String.class, new DefaultStringProvider());
        providers.put(Date.class, new DefaultDateProvider());
    }

   public <T> BOMProvider<T>  fetchValue(Class<T> clazz) {
        BOMProvider<?> provider =  (BOMProvider<?>) providers.get(clazz);
        if(provider == null){
            return null;
        }
        return (BOMProvider<T>) provider;
    }
}