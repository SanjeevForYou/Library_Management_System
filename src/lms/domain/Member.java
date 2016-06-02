package lms.domain;

import lms.util.Gender;

import java.time.LocalDate;

/**
 * Created by 985205 on 6/1/2016.
 */
public class Member extends Person {

    private String memberID;

    public Member(String fname, String lname, LocalDate dob, Gender gender, Address address, LocalDate joinDate, String status, String email, String memberID) {
        super(fname, lname, dob, gender, address, joinDate, status, email);
        this.memberID = memberID;
    }

    public String getMemberID() {
        return memberID;
    }
}
