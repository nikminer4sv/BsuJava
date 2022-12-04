package by.lab2.java;

public class Main {
    public static void main(String[] args) {
        Client client1 = new Client("Nikita", "Korotki", "Denisovich");
        Account account = new Account(client1.getIdentifier(), 100);
    }
}
