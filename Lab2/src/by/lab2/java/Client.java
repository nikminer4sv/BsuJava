package by.lab2.java;

import java.util.concurrent.atomic.AtomicLongArray;

public class Client implements Cloneable {

    private static int lastUserIdentifier = 0;

    private final String name;
    private final String surname;
    private final String patronymic;

    private final int identifier;

    public Client(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.identifier = lastUserIdentifier++;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getIdentifier() {
        return this.identifier;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Client(this.name, this.surname, this.patronymic);
    }
}
