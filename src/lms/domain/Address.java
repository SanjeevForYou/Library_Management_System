package lms.domain;

/**
 * Created by 985176 on 6/1/2016.
 */
public class Address {
    private String street;
    private String city;
    private String zip;
    private String state;

    public Address(String street,String city,String zip,String state){
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
    }
}
