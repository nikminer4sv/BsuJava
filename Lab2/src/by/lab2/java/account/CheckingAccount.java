package by.lab2.java.account;

public class CheckingAccount extends Account {
    private double monthlyCashback;
    public CheckingAccount(int ownerId, double money, double monthlyCashback) {
        super(ownerId, money);
        this.monthlyCashback = monthlyCashback;
    }

    public double getMonthlyCashback() {
        return monthlyCashback;
    }

    public void setMonthlyCashback(double monthlyCashback) {
        this.monthlyCashback = monthlyCashback;
    }

    @Override
    public String getType() {
        return "CheckingAccount";
    }
}
