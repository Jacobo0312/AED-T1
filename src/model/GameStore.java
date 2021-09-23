package model;

import collections.LinkedList;

public class GameStore {

    private int cashiers;
    private LinkedList<Shelve> shelves;
    private LinkedList<Customer> customers;

    public GameStore(int cashiers, LinkedList<Shelve> shelves, LinkedList<Customer> customers) {
        this.cashiers = cashiers;
        this.shelves = shelves;
        this.customers = customers;
    }

    public int getCashiers() {
        return this.cashiers;
    }

    public void setCashiers(int cashiers) {
        this.cashiers = cashiers;
    }

    public LinkedList<Shelve> getShelves() {
        return this.shelves;
    }

    public void setShelves(LinkedList<Shelve> shelves) {
        this.shelves = shelves;
    }

    public String toStringShelves() {

        String message = "\nSHELVES:";

        for (int i = 0; i < shelves.size(); i++) {
            message += shelves.get(i).toString();

        }

        return message;
    }

    public LinkedList<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(LinkedList<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "{" + " cashiers='" + getCashiers() + "'" + ", shelves='" + getShelves() + "'" + ", customers='"
                + getCustomers() + "'" + "}";
    }

    public String section1() {

        String message = "\nSECTION 1:\n";

        for (int i = 0; i < customers.size(); i++) {
            message += customers.get(i).toString() + "\n";

        }
        return message;
    }

    public void insertionSort(LinkedList<Game> games) {
        int n = games.size();
        for (int i = 1; i < n; ++i) {
            Game key = games.get(i);
            int j = i - 1;

            while (j >= 0 && games.get(j).compareTo(key) > 0) {
                games.set(j + 1, games.get(j));
                j = j - 1;
            }
            games.set(j + 1, key);
        }

    }

    public void bubbleSort(LinkedList<Game> games) {
        int n = games.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (games.get(j).compareTo(games.get(j + 1)) > 0) {

                    Game temp = games.get(j);
                    games.set(j, games.get(j + 1));
                    games.set(j + 1, temp);
                }
    }

}
