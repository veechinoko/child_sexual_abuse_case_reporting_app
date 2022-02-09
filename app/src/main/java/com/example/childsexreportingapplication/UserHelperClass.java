package com.example.childsexreportingapplication;

public class UserHelperClass {
    String email, password, fullname, phone;

    public UserHelperClass(){

    }

    public UserHelperClass(String email, String password, String fullname, String phone) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

