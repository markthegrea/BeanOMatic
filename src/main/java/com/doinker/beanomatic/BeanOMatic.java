package com.doinker.beanomatic;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import com.doinker.beanomatic.providers.DedfaultBOMProviderFactory;

import org.apache.commons.lang3.StringUtils;

public class BeanOMatic {

    public static <T> T createBean(Class<T> clazz) {
        return createObject(clazz);
    }

    public static <T> T createBean2(Class<T> clazz) {
        return createObject2(clazz, new DedfaultBOMProviderFactory());
    }

    public static <T> T createObject2(Class<T> clazz, DedfaultBOMProviderFactory fac) {

        T o = null;
        try {
            if (clazz.isEnum()) {
                return clazz.getEnumConstants()[0];
            }
            if (Modifier.isFinal(clazz.getModifiers())) {
                return null;
            }
            o = clazz.getDeclaredConstructor().newInstance();
            if (clazz == Object.class) {
                return o;
            }
            List<Field> fields = new ArrayList<Field>();
            if (clazz.getSuperclass().getSuperclass() != null) {
                fields.addAll(Arrays.asList(clazz.getSuperclass().getSuperclass().getDeclaredFields()));
            }
            fields.addAll(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            for (Field field : fields) {
                field.setAccessible(true);

                if (Modifier.isFinal(field.getModifiers())) {
                    continue;
                }

                if (field.getName().equals("serialVersionUID")) {
                    continue;
                }

                BOMProvider<?> theProvider = fac.fetchValue(field.getType());
                if (theProvider != null){
                    field.set(o, theProvider.fetchValue(field.getName()));
                } else {
                    field.set(o, createObject2(field.getType(), fac));
                }
                
            }
        } catch (Exception e) {
            System.out.println("fail!" + e);
        }
        return o;
    }


    public static <T> T createObject(Class<T> clazz) {

        T o = null;
        try {
            if (clazz.isEnum()) {
                return clazz.getEnumConstants()[0];
            }
            o = clazz.getDeclaredConstructor().newInstance();
            if (clazz == Object.class) {
                return o;
            }
            List<Field> fields = new ArrayList<Field>();
            if (clazz.getSuperclass().getSuperclass() != null) {
                fields.addAll(Arrays.asList(clazz.getSuperclass().getSuperclass().getDeclaredFields()));
            }
            fields.addAll(Arrays.asList(clazz.getSuperclass().getDeclaredFields()));
            fields.addAll(Arrays.asList(clazz.getDeclaredFields()));

            for (Field field : fields) {
                field.setAccessible(true);

                if (Modifier.isFinal(field.getModifiers())) {
                    continue;
                }

                if (field.getName().equals("serialVersionUID")) {
                    continue;
                }


                if (field.getType().equals(String.class)) {
                    field.set(o, field.getName() + "_example");
                    continue;
                }
                if (field.getType().equals(Short.class) || field.getType().equals(short.class)) {
                    field.set(o, Short.valueOf("4"));
                    continue;
                }
                if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
                    field.set(o, Integer.valueOf("42"));
                    continue;
                }
                if (field.getType().equals(Long.class) || field.getType().equals(long.class)) {
                    field.set(o, Long.valueOf("442"));
                    continue;
                }
                if (field.getType().equals(Double.class) || field.getType().equals(double.class)) {
                    field.set(o, Double.valueOf( "42.2"));
                    continue;
                }
                if (field.getType().equals(Boolean.class) || field.getType().equals(boolean.class)) {
                    field.set(o, Boolean.valueOf("true"));
                    continue;
                }
                if (field.getType().equals(BigDecimal.class)) {
                    field.set(o, new BigDecimal( "4242.42"));
                    continue;
                }
                if (field.getType().equals(BigInteger.class)) {
                    field.set(o, new BigInteger( "424242"));
                    continue;
                }
                if (field.getType().equals(Byte.class)) {
                    field.set(o, Byte.valueOf("12"));
                    continue;
                }
                if (field.getType().equals(Calendar.class)) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTimeZone(TimeZone.getTimeZone("UTC"));
                    field.set(o, cal);
                    continue;
                }
                if (field.getType().equals(Date.class)) {
                    field.set(o, new Date());
                    continue;
                }
                if (field.getType().equals(List.class)) {
                    List<Object> l = new ArrayList<Object>();
                    String type = StringUtils.substringBetween(field.getGenericType().getTypeName(), "<", ">");
                    l.add(createObject(Class.forName(type)));
                    l.add(createObject(Class.forName(type)));
                    field.set(o, l);
                    continue;
                }
                if (field.getType().equals(String[].class)) {
                    field.set(o, new String[] { "value1", "value2" });
                    continue;
                }
                // Uncomment when necessary
                // if (field.getType().equals(byte[].class)) {
                // field.set(o, DatatypeConverter.parseHexBinary("3D9599C0"));
                // continue;
                // }
                if (field.getType().toString().startsWith("class ")) {
                    field.set(o, createObject(field.getType()));
                }
            }
        } catch (Exception e) {
            System.out.println("fail!" + e);
        }
        return o;
    }
}