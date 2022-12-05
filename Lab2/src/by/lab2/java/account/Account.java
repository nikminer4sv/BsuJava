package by.lab2.java.account;

public abstract class Account {

    private static int lastUserIdentifier = 0;
    protected int ownerId;
    protected double money;

    protected boolean isBlocked;

    private final int identifier;

    public Account(int ownerId, double money) {
        this.ownerId = ownerId;
        this.money = money;
        this.identifier = lastUserIdentifier++;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void block() {
        this.isBlocked = true;
    }

    public void unblock() {
        this.isBlocked = false;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) { this.money = money; }

    public int getOwnerId() {
        return this.ownerId;
    }

    public int getIdentifier() {
        return identifier;
    }

    public abstract String getType();
}
