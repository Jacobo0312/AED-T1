package model;

import java.util.ArrayList;

public class Shelve {

    private String id;
    private int amountGames;
    private ArrayList<Game> gameList;

    public Shelve(String id, int amountGames, ArrayList<Game> gameList) {
        this.id = id;
        this.amountGames = amountGames;
        this.gameList = gameList;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmountGames() {
        return this.amountGames;
    }

    public void setAmountGames(int amountGames) {
        this.amountGames = amountGames;
    }

    public ArrayList<Game> getGameList() {
        return this.gameList;
    }

    public void setGameList(ArrayList<Game> gameList) {
        this.gameList = gameList;
    }

    @Override
    public String toString() {

        String games = "";

        for (Game game : gameList) {
            games += game.toString();
        }

        return "\n-------------------" + getId() + "-------------------" + "\n" + games;

    }

}
