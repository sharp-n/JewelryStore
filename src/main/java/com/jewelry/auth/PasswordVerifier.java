package com.jewelry.auth;

public class PasswordVerifier {
    private String password;

    public PasswordVerifier(String password) {
        this.password = password;
    }

    public boolean verify(){
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}";
        return password.matches(pattern);
    }
}
