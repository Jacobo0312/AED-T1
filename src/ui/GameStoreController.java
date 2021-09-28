package ui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import collections.LinkedList;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
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

	@FXML
    private Button buttonNext;
	

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

	//CREATE CUSTOMER

	@FXML
    private TextField idCustomer;

    @FXML
    private ListView<Game> listGamesCustomer;

	@FXML
    private ListView<Customer> listCustomer;

	@FXML
	private ObservableList<Game> listGames;

	private int time=1;

	

	//-------------

	//SECTIONS

	@FXML
    private ListView<String> listShelf;
	@FXML
    private Label tittle;
	
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

		gameStore.setCashiers(cashiersNumber);



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
	public  void loadCreateCustomer(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/CreateCustomer.fxml"));
        fxmlLoader.setController(this);
        Parent pane = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);


		
		gameStore.setShelves(shelves);
		gameStore.setGames(games);

		LinkedList<Game> games=gameStore.getGames();


	for (Game game : games) {
		listGamesCustomer.getItems().addAll(game);
		
	}



	listGamesCustomer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	listGames = listGamesCustomer.getSelectionModel().getSelectedItems();

	buttonNext.setOnAction((e) -> {
		try {
			loadShelves(event);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	  });

			
	}


	@FXML
    public void addCustomer(ActionEvent event) {

		LinkedList<Game> customerGameList=new LinkedList<>();

		for (Game game : listGames) {
			customerGameList.add(game);
			
		}


		Customer customer=new Customer(Integer.parseInt(idCustomer.getText()),customerGameList, time++);


		customers.add(customer);
		listCustomer.getItems().add(customer);


		


    }

	@FXML
	public  void loadShelves(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Sections.fxml"));
        fxmlLoader.setController(this);
        Parent pane = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);


		LinkedList<Customer> customerList=new LinkedList<>();
		for (Customer customer : listCustomer.getItems()) {
			customerList.add(customer);
			
		}


		gameStore.setCustomers(customerList);

		tittle.setText("SHELVE");
		listShelf.getItems().add(gameStore.toStringShelves());


		buttonNext.setOnAction((e) -> {
			try {
				loadSection1(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		  });
	}


	@FXML
	public  void loadSection1(ActionEvent event) throws IOException{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Sections.fxml"));
        fxmlLoader.setController(this);
        Parent pane = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);


		tittle.setText("SECTION 1");
		listShelf.getItems().add(gameStore.section1());
		//listShelf.getItems().add();


		buttonNext.setOnAction((e) -> {
			try {
				loadSection2(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		  });
	}



	public  void loadSection2(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Sections.fxml"));
        fxmlLoader.setController(this);
        Parent pane = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);


		tittle.setText("SECTION 2");
		listShelf.getItems().add(gameStore.section2());
		//listShelf.getItems().add();

		buttonNext.setOnAction((e) -> {
			try {
				loadSection3(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		  });


	
	}


	public  void loadSection3(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Sections.fxml"));
        fxmlLoader.setController(this);
        Parent pane = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);


		tittle.setText("SECTION 3");
		listShelf.getItems().add(gameStore.section3());
		

		buttonNext.setOnAction((e) -> {
			try {
				checkoutLine(e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		  });

	}


	private void checkoutLine(ActionEvent event) throws IOException {
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/Sections.fxml"));
        fxmlLoader.setController(this);
        Parent pane = fxmlLoader.load();
        mainPane.getChildren().clear();
        mainPane.getChildren().addAll(pane);


		tittle.setText("CHECKOUT LINE");
		listShelf.getItems().add(gameStore.checkoutLine());

		buttonNext.setText("FINISH");


		buttonNext.setOnAction((e) -> {
			Platform.exit();
		  });
		

		
	}


	@FXML
    public void addGame(ActionEvent event) {


		int code=Integer.parseInt(codeGame.getText());
		int price=Integer.parseInt(priceGame.getText());
		int amount=Integer.parseInt(quantityGame.getText());
		
		String idShelve=choiceBoxShelves.getValue();

		for (Shelve shelve : shelves) {
			if (shelve.getId().equals(idShelve)){
				int value=shelve.getGameList().size();
				Game game=new Game(code, price, amount,idShelve,value);
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
