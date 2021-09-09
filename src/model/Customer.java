package model;

import java.util.ArrayList;

public class Customer {

    private int id;
    private ArrayList<Integer> gameList;

    public Customer(int id, ArrayList<Integer> gameList) {
        this.id = id;
        this.gameList = gameList;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Integer> getGameList() {
        return this.gameList;
    }

    public void setGameList(ArrayList<Integer> gameList) {
        this.gameList = gameList;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", gameList='" + getGameList() + "'" + "}";
    }

}
