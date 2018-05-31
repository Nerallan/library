package by.grsu.budko.library.types;

import java.util.List;

public class Client {

    private int id;
    private String name;
    private String surname;
    private String login;
    private String passwd;

    public Client(int id, String name, String surname, String login, String passwd) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.passwd = passwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }


}
