package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class GameStore {

    private ArrayList<Game> games;



    public GameStore() {
        games=new ArrayList<>();


        try {
            importGames();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

    private void importGames() throws FileNotFoundException, IOException,NumberFormatException {
        String file = "data/dataset_games.csv";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line=br.readLine();
        while ((line = br.readLine()) != null) {
            String[] game = line.split(";");
            
            games.add(new Game(Integer.parseInt(game[0]), game[1], game[2], Integer.parseInt(game[3]), game[4], game[5]));
        }

        br.close();
    }

}
