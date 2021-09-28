package model;

import collections.*;

public class Customer implements Comparable<Customer>{

    private int id;
    private LinkedList<Integer> gameList;
    private LinkedList<Game> games;
    private int time;
    private StackList<Game> shoppingBag;

    public Customer(int id, LinkedList<Game> gameList,int time) {
        this.id = id;
        //this.gameList = gameList;
        this.games=gameList;
        this.time=time;
        this.shoppingBag=new StackList<>();
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


    public LinkedList<Game> getGames() {
        return this.games;
    }

    public void setGames(LinkedList<Game> games) {
        this.games = games;
    }


    public int getTime() {
        return this.time;
    }

    public void setTime(int time) {
        this.time = time;
    }



    public StackList<Game> getShoppingBag() {
        return this.shoppingBag;
    }

    public void setShoppingBag(StackList<Game> shoppingBag) {
        this.shoppingBag = shoppingBag;
    }




    @Override
    public String toString() {

        String gamesString = "";

        for (int i = 0; i < games.size(); i++) {
            gamesString += "CODE: " +  games.get(i).getCode()+"\n";
        }

        return "ID:" + getId()+"\n" + gamesString;
    }

    @Override
    public int compareTo(Customer o) {
        return getTime()-o.getTime();
    }

    public void addTime() {

        this.time=getTime()+1;
    }

}
