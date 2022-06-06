package com.jewelry.auth;

public class Authentication {

    private final String userHashCode;

    public Authentication(String userHashCode) {
        this.userHashCode = userHashCode;
    }

    public boolean findTheSame(){
        String users = WorkWithFiles.read("src\\users.txt");
        return users.contains(userHashCode);
    }

}
