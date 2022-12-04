package by.lab2.java;

public class Account {
    private int ownerId;
    private double money;

    private boolean isBlocked;

    public Account(int ownerId, double money) {
        this.ownerId = ownerId;
        this.money = money;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void Block() {
        this.isBlocked = true;
    }

    public void Unblock() {
        this.isBlocked = false;
    }

    public double getMoney() {
        return this.money;
    }

    public int getOwnerId() {
        return this.ownerId;
    }
}
