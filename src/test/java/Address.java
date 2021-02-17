import org.apache.commons.lang3.builder.ToStringBuilder;

public class Address {

    private String street;
    private String zipCode;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
    
}
