package com.doinker.beanomatic.providers;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.doinker.beanomatic.BOMProvider;
import com.doinker.beanomatic.BOMType;

public class DefaultDateProvider implements BOMProvider<Date>{

private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public Date fetchValue(String name) {
        try {
            return formatter.parse((String)BOMType.DATE.defaultValue);
        } catch(Exception e) {
            System.out.println(e);
            //noop
        }
        return null;
    }
}