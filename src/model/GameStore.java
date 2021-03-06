package model;

import collections.LinkedList;
import collections.QueueList;
import collections.StackList;

public class GameStore {

    private LinkedList<Cashier> cashiers;
    private LinkedList<Shelve> shelves;
    private LinkedList<Customer> customers;
    private LinkedList<Game> games;
    private LinkedList<Customer> output;

    public GameStore(int cashiersNumber, LinkedList<Shelve> shelves, LinkedList<Customer> customers,
            LinkedList<Game> games) {
        this.shelves = shelves;
        this.customers = customers;
        this.games = games;
        this.cashiers = createCashier(cashiersNumber);
        

    }

    public GameStore() {
        this.output=new LinkedList<>();
    }

    private LinkedList<Cashier> createCashier(int cashiersNumber) {

        LinkedList<Cashier> cashiers = new LinkedList<>();

        for (int i = 0; i < cashiersNumber; i++) {
            cashiers.add(new Cashier(i));
        }
        return cashiers;
    }

    public LinkedList<Cashier> getCashiers() {
        return this.cashiers;
    }

    public void setCashiers(int cashiersNumber) {
        this.cashiers = createCashier(cashiersNumber);
    }

    public LinkedList<Shelve> getShelves() {
        return this.shelves;
    }


    public LinkedList<Game> getGames() {
        return this.games;
    }

    public void setGames(LinkedList<Game> games) {
        this.games = games;
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

    public String section1() {

        /*

        for (Customer customer : customers) {

            LinkedList<Game> gameListCustomer = new LinkedList<>();
            LinkedList<Integer> codeGames = customer.getGameList();

            for (Integer code : codeGames) {
                for (Game game : games) {
                    if (code == game.getCode()) {
                        gameListCustomer.add(game);
                    }

                }
            }

            customer.setGames(gameListCustomer);
        }
        */

        //String message = "\nSECTION 1:\n\n";
        String message="";

        for (Customer customer : customers) {
            message += customer.toString() + "\n";

        }
        return message;
    }

    public String section2() {

        //String message = "\nSECTION 2:\n\n";
        String message="";

        for (Customer customer : customers) {
            // Calculate the best route

            double test=Math.random()*2;
            if (test>1){
                insertionSort(customer.getGames());
            }else{
                bubbleSort(customer.getGames());
            }
            
            message += customer.toString();
            message += "TIME: " + customer.getTime() + "\n\n";
        }

        return message;
    }

    public String section3() {
        //String message = "\nSECTION 3:\n\n";
        String message="";


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
            message += customer.getShoppingBag();
            message += "TIME: " + customer.getTime() + "\n\n";
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

    private QueueList<Customer> enqueueCustomers() {
        QueueList<Customer> queueList = new QueueList<>();
        for (Customer customer : customers) {
            queueList.enqueue(customer);

        }

        return queueList;
    }

    public String checkoutLine() {
        String message = "";

        QueueList<Customer> queueList = enqueueCustomers();

        // message += "\n------CHECKOUT LINE------\n" + queueList;

        int time = 0;
        Boolean allExit = false;

        while (!allExit) {

            message += "\nTIME: " + time + "\n";
            time++;
            for (int i = 0; i < cashiers.size(); i++) {
                Cashier cashier = cashiers.get(i);

                if (cashier.isEmpty() && !queueList.isEmpty()) {
                    Customer customer=queueList.dequeue().getItem();

                    cashier.setCustomer(customer);
                    output.add(customer);
                } else {
                    cashier.passGame();
                    if (cashier.isEmpty() && !queueList.isEmpty()){
                        Customer customer=queueList.dequeue().getItem();

                    cashier.setCustomer(customer);
                    output.add(customer);
                    }

                    
                }
                message += "\n" + cashier + "\n";
            }

            if (allCashierIsEmpty()) {
                allExit = true;
            }

        }

        return message;
    }


    public String getOutput(){
        String message="";

        for (Customer customer : output) {
            message+="\n\nID: "+customer.getId()+"\n";
            message+=customer.getInvoice()+"\n";

            LinkedList<Game> gList=customer.getGames();
            for (Game game : gList) {
                message+=game.getCode()+" ";
            }
            
        }

        return message;
    }

    private boolean allCashierIsEmpty() {

        for (Cashier cashier : cashiers) {
            if (!cashier.isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
