package model;

public class Game implements Comparable<Game>{

    private int code;
    private int price;
    private int amount;
    private int value;

    public Game(int code, int price, int amount,int value) {
        this.code = code;
        this.price = price;
        this.amount = amount;
        this.value=value;
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


    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "CODE: " + getCode() + "     " + "PRICE:" + getPrice() + "     " + "AMOUNT: " + getAmount() + "\n";
    }

    @Override
    public int compareTo(Game o) {
        return getValue()-(o.getValue());
    }

}
