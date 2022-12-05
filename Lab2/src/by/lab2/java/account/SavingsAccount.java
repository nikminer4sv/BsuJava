package by.lab2.java.account;

public class SavingsAccount extends Account {

    private boolean isReplenished;
    private boolean isWithdrawed;

    public SavingsAccount(int ownerId, double money, boolean isReplenished, boolean isWithdrawed) {
        super(ownerId, money);
        this.isReplenished = isReplenished;
        this.isWithdrawed = isWithdrawed;
    }

    public boolean isReplenished() {
        return isReplenished;
    }

    public void setReplenished(boolean replenished) {
        isReplenished = replenished;
    }

    public boolean isWithdrawed() {
        return isWithdrawed;
    }

    public void setWithdrawed(boolean withdrawed) {
        isWithdrawed = withdrawed;
    }

    @Override
    public String getType() {
        return "SavingsAccount";
    }
}
