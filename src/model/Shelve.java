package model;

import collections.LinkedList;

public class Shelve {

    private String id;
    private LinkedList<Game> gameList;


    public Shelve(String id,LinkedList<Game> gameList) {
        this.id = id;
        this.gameList = gameList;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }



    public LinkedList<Game> getGameList() {
        return this.gameList;
    }

    public void setGameList(LinkedList<Game> gameList) {
        this.gameList = gameList;
    }

    @Override
    public String toString() {

        String games = "";

        for (int i = 0; i < gameList.size(); i++) {
            games += gameList.get(i).toString();
        }

        return "\n-------------------" + getId() + "-------------------" + "\n" + games;

    }

}
