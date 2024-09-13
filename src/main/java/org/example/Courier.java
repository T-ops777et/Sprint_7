package org.example;

import java.util.Random;

public class Courier {

private String login;
private String password;
private String firstName;

    public static Courier generic() {
        return new Courier("test", "1234", "tests");
    }

    public static Courier random() {
        return new Courier("test" + new Random().nextInt(1000), "1234", "tests");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Courier(String login, String password, String firstName) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }

    public Courier() {
    }
}
