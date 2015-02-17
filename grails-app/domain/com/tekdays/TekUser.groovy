package com.tekdays

class TekUser {
    String userName
    String email
    String fullName
    String password
    String website
    String bio

    static constraints = {
        fullName()
        userName()
        email()
        website()
        bio maxSize: 5000
    }

    @Override
    public String toString() {
        return "TekUser{" +
                "fullName='" + fullName + '}';
    }
}
