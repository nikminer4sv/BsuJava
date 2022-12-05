package by.lab2.java;

import by.lab2.java.account.Account;
import by.lab2.java.account.CheckingAccount;
import by.lab2.java.account.SavingsAccount;
import by.lab2.java.exception.AccountNotFoundException;
import by.lab2.java.exception.ClientNotFoundException;

import java.util.ArrayList;

public class Bank {
    private final ArrayList<Account> accounts;
    private final ArrayList<Client> clients;

    private String title;

    public Bank(String title) {
        accounts = new ArrayList<Account>();
        clients = new ArrayList<Client>();
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void addClient(Client client) {
        if (client == null)
            throw new NullPointerException("Client can't be null");
        this.clients.add(client);
    }

    public Client getClientById(int clientId) {
        if (clientId < 0)
            return null;
        for (int i = 0; i < clients.size(); i++)
            if (clients.get(i).getIdentifier() == clientId)
                return clients.get(i);
        return null;
    }

    public boolean isClientExists(int clientId) {
        if (clientId < 0)
            return false;
        for (int i = 0; i < this.clients.size(); i++)
            if (this.clients.get(i).getIdentifier() == clientId)
                return true;
        return false;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void createCheckingAccount(int clientId, double money, double monthlyCashback) throws ClientNotFoundException {
        if (!isClientExists(clientId))
            throw new ClientNotFoundException(String.format("Client with id %d doesn't exists.", clientId));
        if (money < 0)
            throw new IllegalArgumentException("Money can't be less than 0.");
        this.accounts.add(new CheckingAccount(clientId, money, monthlyCashback));
    }

    public void createSavingsAccount(int clientId, double money, boolean isReplenished, boolean isWithdrawed) throws ClientNotFoundException {
        if (!isClientExists(clientId))
            throw new ClientNotFoundException(String.format("Client with id %d doesn't exists.", clientId));
        if (money < 0)
            throw new IllegalArgumentException("Money can't be less than 0.");
        this.accounts.add(new SavingsAccount(clientId, money, isReplenished, isWithdrawed));
    }

    public ArrayList<Account> getAccounts() {
        return this.accounts;
    }

    public ArrayList<Account> getClientAccounts(int id) {
        ArrayList<Account> result = new ArrayList<Account>();
        for (int i = 0; i < this.accounts.size(); i++)
            if (this.accounts.get(i).getOwnerId() == id)
                result.add(this.accounts.get(i));
        return result;
    }

    public void blockAccount(int accountId) {
        for (int i = 0; i < this.accounts.size(); i++)
            if (this.accounts.get(i).getIdentifier() == accountId)
                this.accounts.get(i).block();
    }

    public void unblockAccount(int accountId) {
        for (int i = 0; i < this.accounts.size(); i++)
            if (this.accounts.get(i).getIdentifier() == accountId)
                this.accounts.get(i).unblock();
    }

    public boolean isBlockedAccount(int accountId) throws AccountNotFoundException {
        for (int i = 0; i < this.accounts.size(); i++)
            if (this.accounts.get(i).getIdentifier() == accountId)
                return this.accounts.get(i).isBlocked();
        throw new AccountNotFoundException(String.format("Account with id %d not found.", accountId));
    }

    public double getClientMoney(int clientId) {
        double sum = 0;
        ArrayList<Account> clientAccounts = getClientAccounts(clientId);
        for (int i = 0; i < clientAccounts.size(); i++) {
            if (!clientAccounts.get(i).isBlocked())
                sum += clientAccounts.get(i).getMoney();
        }
        return sum;
    }
}
