package com.jewelry.auth;

public class Authorisation {

    private final String login;

    private String hashedLogin;

    public Authorisation(String login) {
        this.login = login;
    }

    public boolean authorisation(){
        Hashing hash = new Hashing();
        hashedLogin = hash.hash(login);
        return !isAvailableName(hashedLogin);
    }

    public boolean isAvailableName(String hashCode){
        String fileText = WorkWithFiles.read("src\\logins.txt");
        return fileText.contains(hashCode);
    }

    public boolean isExistsEmail(String hashedEmail){
        String fileText = WorkWithFiles.read("src\\emails.txt");
        return fileText.contains(hashedEmail);
    }

}
