package lms.domain;

import lms.util.Gender;

import java.time.LocalDate;

/**
 * Created by 985176 on 6/1/2016.
 */
public class Person {
    private String fname;
    private String lname;
    private LocalDate dob;
    private Gender gender;
    Address address;
    private LocalDate joinDate;
    private String status;
    private String email;

    public Person(String fname,String lname,LocalDate dob,Gender gender,Address address,LocalDate joinDate,String status,String email){
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.joinDate = joinDate;
        this.status = status;
        this.email = email;
    }

    public Person() {

    }
}
