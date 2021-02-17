package com.doinker.beanomatic;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;


public class TestBeanOMatic {
   
    @Test
    public void testCreateObject() {

        Person person = BeanOMatic.createBean(Person.class);
        System.out.println(ToStringBuilder.reflectionToString(person, ToStringStyle.JSON_STYLE));
        assertNotNull(person);

    }

    @Test
    public void testCreateObject2() {

        Person person = BeanOMatic.createBean2(Person.class);
        System.out.println(ToStringBuilder.reflectionToString(person, ToStringStyle.JSON_STYLE));
        assertNotNull(person);

    }
}
