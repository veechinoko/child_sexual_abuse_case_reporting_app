package com.example.childsexreportingapplication;

public class UserCrimedetails {
    String crimeTitle, location, contactPhone, crimeDetails;

    public  UserCrimedetails()
    {

    }

    public UserCrimedetails(String crimeTitle, String location, String contactPhone, String crimeDetails) {
        this.crimeTitle = crimeTitle;
        this.location = location;
        this.contactPhone = contactPhone;
        this.crimeDetails = crimeDetails;
    }

    public String getCrimeTitle() {
        return crimeTitle;
    }

    public void setCrimeTitle(String crimeTitle) {
        this.crimeTitle = crimeTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCrimeDetails() {
        return crimeDetails;
    }

    public void setCrimeDetails(String crimeDetails) {
        this.crimeDetails = crimeDetails;
    }
}

