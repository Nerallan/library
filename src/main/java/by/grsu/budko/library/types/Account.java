package by.grsu.budko.library.types;

public class Account {

    private int id;
    private double balance;
    private int idClient;
    private boolean active;

    public Account(int id, double balance, int idClient, boolean active){

        this.id=id;
        this.balance=balance;
        this.idClient=idClient;
        this.active=active;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



}
