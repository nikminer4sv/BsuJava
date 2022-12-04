package by.lab2.java;

import by.lab2.java.Account.Account;
import by.lab2.java.Account.CheckingAccount;
import by.lab2.java.Account.SavingsAccount;
import by.lab2.java.Exception.ClientNotFoundException;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Client> clients;

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

    public ArrayList<Client> getClients() throws CloneNotSupportedException {
        ArrayList<Client> result = new ArrayList<Client>();
        for (Client client : clients)
            result.add((Client)client.clone());
        return result;
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
}
