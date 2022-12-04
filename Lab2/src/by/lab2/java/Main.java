package by.lab2.java;

import by.lab2.java.Account.Account;
import by.lab2.java.Account.CheckingAccount;
import by.lab2.java.Exception.ClientNotFoundException;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Nikita", "Korotki", "Denisovich");
        Account account = new CheckingAccount(client1.getIdentifier(), 100, 1.5);
        Bank bank = new Bank("Belarusbank");
        bank.addClient(client1);
        try {

            bank.createCheckingAccount(123, 100, 1.5);
            boolean client = bank.isClientExists(123);
            System.out.println();

        } catch (ClientNotFoundException e) {
            System.out.println("Invalid client id");
        }
    }
}
