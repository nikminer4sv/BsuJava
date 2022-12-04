package by.lab2.java.Account;

import by.lab2.java.Account.Account;

public class SavingsAccount extends Account {

    private boolean isReplenished;
    private boolean isWithdrawed;

    public SavingsAccount(int ownerId, double money, boolean isReplenished, boolean isWithdrawed) {
        super(ownerId, money);
        this.isReplenished = isReplenished;
        this.isWithdrawed = isWithdrawed;
    }

    @Override
    public String getType() {
        return "SavingsAccount";
    }
}
