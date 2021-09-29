package model;

import collections.StackList;

public class Cashier {

    private int id;
    private Customer customer;
    private StackList<Game> purchase;
    private int invoice;

    public Cashier(int id) {
        this.id = id + 1;
        this.customer = null;
        this.purchase = new StackList<Game>();
        this.invoice = 0;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StackList<Game> getPurchase() {
        return this.purchase;
    }

    public void setPurchase(StackList<Game> purchase) {
        this.purchase = purchase;
    }

    public int getInvoice() {
        return this.invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    public void passGame() {

        if (customer != null) {
            if (customer.getShoppingBag().isEmpty()) {

                customer = null;
                invoice = 0;
                purchase = new StackList<Game>();

            } else {
                Game game = customer.getShoppingBag().pop().getItem();
                invoice += game.getPrice();
                purchase.push(game);
            }
        }

    }

    @Override
    public String toString() {

        String message;
        if (getCustomer()==null){
            message="isEmpty";
        }else{
            message=getCustomer()+"";
        }

        return "CASHIER: " + getId() + "\nCUSTOMER:" + message +"\nPurchase:\n" + getPurchase()+ "\nInvoice: " + getInvoice() +"\n";
    }

    public boolean isEmpty() {
        Boolean isEmpty = (customer == null) ? true : false;
        return isEmpty;
    }

}
