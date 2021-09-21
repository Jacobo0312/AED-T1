package model;

public class Game {

    private int code;
    private int price;
    private int amount;

    public Game(int code, int price, int amount) {
        this.code = code;
        this.price = price;
        this.amount = amount;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CODE: " + getCode() + "     " + "PRICE:" + getPrice() + "     " + "AMOUNT: " + getAmount() + "\n";
    }

}
