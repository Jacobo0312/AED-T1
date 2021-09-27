package ui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import collections.LinkedList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Customer;
import model.Game;
import model.GameStore;
import model.Shelve;


public class GameStoreController {

	private GameStore gameStore;

	@FXML
    private Pane mainPane;

	//SETTINGS
	
    @FXML
    private TextField numberShelves;

    @FXML
    private TextField numberCashiers;



	//----------------------------


	//CREATE GAME

	@FXML
    private TextField codeGame;

    @FXML
    private TextField priceGame;

    @FXML
    private TextField quantityGame;

	@FXML
    private ChoiceBox<String> choiceBoxShelves;

	//TABLE

	
	@FXML
    private TableView<Game> tableGames;

    @FXML
    private TableColumn<Game, Integer> codeGameTable;

    @FXML
    private TableColumn<Game, String> shelfTable;

    @FXML
    private TableColumn<Game, Integer> quantityTable;

    @FXML
    private TableColumn<Game, Integer> priceTable;





	//-----

	//Parameters GameStore


	private int shelvesNumber;
	private int cashiersNumber;
	private LinkedList<Shelve> shelves;
	private LinkedList<Customer> customers;
	private LinkedList<Game> games;
	
    
	public GameStoreController(GameStore gameStore) {
		this.gameStore = gameStore;
		shelves=new LinkedList<>();
		games=new LinkedList<>();
		customers=new LinkedList<>();
		
	}


	@FXML
    public void settingGameStore(ActionEvent event) throws IOException {

		shelvesNumber=Integer.parseInt(numberShelves.getText());
		cashiersNumber=Integer.parseInt(numberCashiers.getText());


		loadCreateGame(event);

    }

	@FXML
	public  void loadCreateGame(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/CreateGame.fxml"));
        fxmlLoader.setController(this);
        Parent pane = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);


		for ( int i=0; i<shelvesNumber; i++) {
			char char1 = (char) ('A' + i );
			String id=char1+"";
			choiceBoxShelves.getItems().add(id);
			LinkedList<Game> gamesList=new LinkedList<>();
			shelves.add(new Shelve(id,gamesList));
			}

			//Verify length


			initializeGamesTableView ();
	}


	
    @FXML
    public void addGame(ActionEvent event) {


		int code=Integer.parseInt(codeGame.getText());
		int price=Integer.parseInt(priceGame.getText());
		int amount=Integer.parseInt(quantityGame.getText());
		
		String idShelve=choiceBoxShelves.getValue();

		for (Shelve shelve : shelves) {
			if (shelve.getId().equals(idShelve)){
				Game game=new Game(code, price, amount,idShelve, 0);
				shelve.getGameList().add(game);
				games.add(game);

				//Check value
				//Change for index and value for id
			}
			
		}


		initializeGamesTableView ();
		
    }



	public void initializeGamesTableView () {
		ArrayList<Game> games1=new ArrayList<>();
		for (Game game : games) {
			games1.add(game);
		}
    	

    	ObservableList<Game> observableList = FXCollections.observableArrayList(games1);
		tableGames.setItems(observableList);
    	codeGameTable.setCellValueFactory(new PropertyValueFactory<Game, Integer>("code"));
    	shelfTable.setCellValueFactory(new PropertyValueFactory<Game, String>("shelve"));
    	quantityTable.setCellValueFactory(new PropertyValueFactory<Game, Integer>("amount"));
    	priceTable.setCellValueFactory(new PropertyValueFactory<Game, Integer>("price"));
    }





	
	
}
