package model;

import collections.LinkedList;
import collections.StackList;

public class GameStore {

    private int cashiers;
    private LinkedList<Shelve> shelves;
    private LinkedList<Customer> customers;
    private LinkedList<Game> games;

    public GameStore(int cashiers, LinkedList<Shelve> shelves, LinkedList<Customer> customers, LinkedList<Game> games) {
        this.cashiers = cashiers;
        this.shelves = shelves;
        this.customers = customers;
        this.games = games;
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

        for (Customer customer : customers) {

            LinkedList<Game> gameListCustomer = new LinkedList<>();
            LinkedList<Integer> codeGames = customer.getGameList();

            // try with binary search

            for (Integer code : codeGames) {
                for (Game game : games) {
                    if (code == game.getCode()) {
                        gameListCustomer.add(game);
                    }

                }
            }

            customer.setGames(gameListCustomer);
        }

        String message = "\nSECTION 1:\n\n";

        for (Customer customer : customers) {
            message += customer.toString() + "\n";

        }
        return message;
    }

    public String section2() {

        String message = "\nSECTION 2:\n\n";

        for (Customer customer : customers) {
            // Calculate the best route
            insertionSort(customer.getGames());
            message += customer.toString();
            message += "TIME: " + customer.getTime() + "\n";
        }

        return message;
    }

    public String section3() {
        String message = "\nSECTION 3:\n\n";

        for (Customer customer : customers) {

            StackList<Game> shoppingBag = customer.getShoppingBag();

            for (Game game : customer.getGames()) {
                if (game.getAmount() > 0) {
                    shoppingBag.push(game);
                    game.setAmount(game.getAmount() - 1);
                    customer.addTime();
                }
            }

        }

        // SORT
        sortCustomer(customers);

        for (Customer customer : customers) {
            message += "ID:" + customer.getId() + "\n";
            message += customer.getShoppingBag().toString();
            message += "TIME: " + customer.getTime() + "\n";
        }

        return message;
    }

    private void insertionSort(LinkedList<Game> games) {
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

    private void sortCustomer(LinkedList<Customer> customers) {
        int n = customers.size();
        for (int i = 1; i < n; ++i) {
            Customer key = customers.get(i);
            int j = i - 1;

            while (j >= 0 && customers.get(j).compareTo(key) > 0) {
                customers.set(j + 1, customers.get(j));
                j = j - 1;
            }
            customers.set(j + 1, key);
        }

    }

    private void bubbleSort(LinkedList<Game> games) {
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
