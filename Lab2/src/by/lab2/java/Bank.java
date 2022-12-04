package by.lab2.java;

import by.lab2.java.Exception.ClientNotFoundException;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;
    private ArrayList<Client> clients;

    public Bank() {
        accounts = new ArrayList<Account>();
        clients = new ArrayList<Client>();
    }

    public void addClient(Client client) {
        if (client == null)
            throw new NullPointerException("Client can't be null");
        this.clients.add(client);
    }

    public Client getClientById(int id) throws ClientNotFoundException {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getIdentifier() == id)
                return clients.get(i);
        }
        throw new ClientNotFoundException(String.format("Client with id %f not found.", id));
    }

    public ArrayList<Client> getClients() throws CloneNotSupportedException {
        ArrayList<Client> result = new ArrayList<Client>();
        for (Client client : clients)
            result.add((Client)client.clone());
        return result;
    }

    public void addAccount(Account account) {
        if (account == null)
            throw new NullPointerException("Account can't be null");
        this.accounts.add(account);
    }
}
