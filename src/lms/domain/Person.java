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
}
