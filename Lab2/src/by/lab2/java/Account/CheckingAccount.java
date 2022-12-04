package by.lab2.java.Account;

import by.lab2.java.Account.Account;

public class CheckingAccount extends Account {
    private double monthlyCashback;
    public CheckingAccount(int ownerId, double money, double monthlyCashback) {
        super(ownerId, money);
        this.monthlyCashback = monthlyCashback;
    }

    @Override
    public String getType() {
        return "CheckingAccount";
    }
}
