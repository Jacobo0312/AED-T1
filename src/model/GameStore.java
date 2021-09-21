package model;

import java.util.ArrayList;

public class GameStore {

    private int cashiers;
    private ArrayList<Shelve> shelves;
    private ArrayList<Customer> customers;

    public GameStore(int cashiers, ArrayList<Shelve> shelves, ArrayList<Customer> customers) {
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

    public ArrayList<Shelve> getShelves() {
        return this.shelves;
    }

    public void setShelves(ArrayList<Shelve> shelves) {
        this.shelves = shelves;
    }

    public String toStringShelves() {

        String message = "\nSHELVES:";
        for (Shelve shelve : shelves) {
            message += shelve.toString();

        }
        return message;
    }

    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "{" + " cashiers='" + getCashiers() + "'" + ", shelves='" + getShelves() + "'" + ", customers='"
                + getCustomers() + "'" + "}";
    }

    public String section1() {
        return null;
    }

}
