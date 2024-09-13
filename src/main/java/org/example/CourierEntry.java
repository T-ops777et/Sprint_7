package org.example;

public class CourierEntry {
    private String login;
    private String password;

    public static CourierEntry from(Courier requestBody) {
        return new CourierEntry(requestBody.getLogin(), requestBody.getPassword());
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

    public CourierEntry(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public CourierEntry() {
    }
    public CourierEntry(String password) {
        this.password = password;
    }
}
