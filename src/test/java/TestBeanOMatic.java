import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.doinker.beanomatic.BeanOMatic;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.jupiter.api.Test;


public class TestBeanOMatic {
   
    @Test
    public void testStuff() {

        Person person = BeanOMatic.createBean(Person.class);
        System.out.println(ToStringBuilder.reflectionToString(person));
        assertNotNull(person);

    }
}
