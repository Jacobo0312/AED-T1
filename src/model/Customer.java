package model;

import collections.LinkedList;

public class Customer {

    private int id;
    //Esto debe ser <Game>
    private LinkedList<Integer> gameList;

    public Customer(int id, LinkedList<Integer> gameList) {
        this.id = id;
        this.gameList = gameList;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<Integer> getGameList() {
        return this.gameList;
    }

    public void setGameList(LinkedList<Integer> gameList) {
        this.gameList = gameList;
    }

    @Override
    public String toString() {

        String games = "";

        for (int i = 0; i < gameList.size(); i++) {
            games += gameList.get(i).toString() + "\n";
        }

        return "ID:" + getId() + games;
    }

}
