package com.example.childsexreportingapplication;

public class AdminHelperClass {
    String aFullname, aGender, aContact_Phone, aEmail, aPassword;

    public AdminHelperClass()
    {

    }

    public AdminHelperClass(String aFullname, String aGender, String aContact_Phone, String aEmail, String aPassword) {
        this.aFullname = aFullname;
        this.aGender = aGender;
        this.aContact_Phone = aContact_Phone;
        this.aEmail = aEmail;
        this.aPassword = aPassword;
    }

    public String getaFullname() {
        return aFullname;
    }

    public void setaFullname(String aFullname) {
        this.aFullname = aFullname;
    }

    public String getaGender() {
        return aGender;
    }

    public void setaGender(String aGender) {
        this.aGender = aGender;
    }

    public String getaConatct_Phone() {
        return aContact_Phone;
    }

    public void setaConatct_Phone(String aConatct_Phone) {
        this.aContact_Phone = aConatct_Phone;
    }

    public String getaEmail() {
        return aEmail;
    }

    public void setaEmail(String aEmail) {
        this.aEmail = aEmail;
    }

    public String getaPassword() {
        return aPassword;
    }

    public void setaPassword(String aPassword) {
        this.aPassword = aPassword;
    }
}
