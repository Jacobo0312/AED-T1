package model;

import collections.LinkedList;

public class Customer {

    private int id;
    private LinkedList<Integer> gameList;
    private LinkedList<Game> games;
    private int time;

    public Customer(int id, LinkedList<Integer> gameList,int time) {
        this.id = id;
        this.gameList = gameList;
        this.games=new LinkedList<>();
        this.time=time;
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



    @Override
    public String toString() {

        String gamesString = "";

        for (int i = 0; i < games.size(); i++) {
            gamesString += "CODE: " +  games.get(i).getCode()+"\n";
        }

        return "ID:" + getId()+"\n" + gamesString;
    }

}
