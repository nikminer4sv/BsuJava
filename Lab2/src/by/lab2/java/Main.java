package by.lab2.java;

import by.lab2.java.exception.ClientNotFoundException;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Nikita", "Korotki", "Denisovich");
        Client client2 = new Client("Nikita2", "Korotki2", "Denisovich2");
        Bank bank = new Bank("Belarusbank");
        bank.addClient(client1);
        bank.addClient(client2);
        try {
            bank.createCheckingAccount(0, 100, 1.5);
            bank.createCheckingAccount(0, 300, 5.5);
            bank.createSavingsAccount(0, 123, true, false);

            bank.blockAccount(1);

            System.out.println(bank.getClientMoney(0));
        } catch (ClientNotFoundException e) {
            System.out.println("Invalid client id");
        }
    }
}
