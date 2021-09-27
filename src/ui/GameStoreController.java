package ui;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import exceptions.NoIdentificationException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Book;
import model.Client;
import model.HashTable;
import model.Queue;
import model.ValueComparator;

public class NationalLibraryController {
	
	private Client client;
	
	private Stage stage;
	@FXML
	private BorderPane basePane;

    @FXML
    private TableView<Book> tableBooks;

    @FXML
    private TableColumn<Book,String> idTitle;

    @FXML
    private TableColumn<Book,String> idISBN;

    @FXML
    private TableColumn<Book,Integer> idRack;

    @FXML
    private TableColumn<Book,String> idChapter;

    @FXML
    private TableColumn<Book,String> idReview;

    @FXML
    private TableColumn<Book,String> idCritique;
    @FXML
    private TableColumn<Book, Integer> idCost;

    @FXML
    private TableColumn<Book,Integer> idQuantity;
    
    
    @FXML
    private TextField identificationTextField;
    
    @FXML
    private TextField isbnAdd;
    
    @FXML
    private TextField quantityAdd;
    
    
    @FXML
    private TableView<Book> tableSearchBooks;
    
    @FXML
    private TableColumn<Book,String> isbnSearchBooks;
    
    @FXML
    private TableColumn<Book,Integer> rackSearchBooks;
    
    @FXML
    private ChoiceBox<String> sortByBox;
    
    @FXML
    private TableView<Book> tableMyBasket;
    
    @FXML
    private TableColumn<Book,String> isbnMyBasket;
    
    @FXML
    private TableColumn<Book,Integer> rackMyBasket;
    
    
    @FXML
    private TableView<Client> tableQueue;
    
    @FXML
    private TableColumn<Client,String> identificationQueue;
    
    @FXML
    private TableColumn<Client,Integer> quantityBooksQueue;
    
    @FXML
    private TableView<Client> tableExit;
    
    @FXML
    private TableColumn<Client,String> identificationExit;
    
    @FXML
    private TableColumn<Client,String> isbnsBooksExit;
    
    @FXML
    private TableColumn<Client,Integer> priceExit;
    
    @FXML
    private TextField numberOfShelvings;
    
    @FXML
    private TextField numberCashRegister;
    
    private HashTable books;
    
    private int numClients;
    
    private Queue queue;
    
    private ArrayList<Client> clients;
    private ArrayList<Client> clients2;
    
    private ArrayList<Client> updateClients;
    
    private Client[] paymentBoxes;
    
    private int cont;
    
	public NationalLibraryController(Stage s) throws NoIdentificationException {
		stage=s;
		books = new HashTable();
		stage.setResizable(false);
		numClients=0;
		clients=new ArrayList<Client>();
		clients2=new ArrayList<Client>();
		updateClients=new ArrayList<Client>();
		queue=new Queue();
		cont=0;
	}
	
	public void initialize() {
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			
			@Override
			public void handle(WindowEvent event) {
				numClients=0;
				System.out.println("Closing the window!");
			}
		});

	}
	
	public void loadConfiguration(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Configuration.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadSection1(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion1.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadBooksList();
		
	}
	public void loadSection2(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion2.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadTableSearchBooks(client.getSearchBooks());
		loadTableMyBasket(client.getBuyBooks());
		sortByBox.getItems().addAll("BubbleSort","HeapSort","MergeSort");
		sortByBox.setValue("BubbleSort");
	}
	
	public void loadSection3(){
		FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion3.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		loadQueueTable();
		paymentBooks();
		getFinalReport();
		exitTable();
	}
	
	public void loadBooksList() {
	    	basePane.setOnKeyPressed(null);
	    	FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion1.fxml"));
			fxmload.setController(this);
			Parent root;
			try {
				root = fxmload.load();
				basePane.getChildren().clear();
				basePane.setCenter(root);
			} catch (IOException e) {
				e.printStackTrace();
			}
			tableBooks.getItems().clear();
			ArrayList<Book> list=books.booksList();
			ObservableList<Book>books= FXCollections.observableArrayList(list);
			tableBooks.setItems(books);
			
			idTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
			idISBN.setCellValueFactory(new PropertyValueFactory<Book, String>("key"));
			idRack.setCellValueFactory(new PropertyValueFactory<Book, Integer>("value"));
			idChapter.setCellValueFactory(new PropertyValueFactory<Book,String>("chapter"));
			idReview.setCellValueFactory(new PropertyValueFactory<Book, String>("review"));
			idCritique.setCellValueFactory(new PropertyValueFactory<Book, String>("critique"));
			idCost.setCellValueFactory(new PropertyValueFactory<Book,Integer>("cost"));
			idQuantity.setCellValueFactory(new PropertyValueFactory<Book, Integer>("quantity"));
	}
	
	public void loadTableSearchBooks(ArrayList<Book> h) {
    	basePane.setOnKeyPressed(null);
    	FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion2.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		tableSearchBooks.getItems().clear();
		ArrayList<Book> list=client.getSearchBooks();
		ObservableList<Book>books= FXCollections.observableArrayList(list);
		tableSearchBooks.setItems(books);
		isbnSearchBooks.setCellValueFactory(new PropertyValueFactory<Book, String>("key"));
		rackSearchBooks.setCellValueFactory(new PropertyValueFactory<Book, Integer>("value"));
}
	public void refreshTableSearchBook() {
		tableSearchBooks.getItems().clear();
		ArrayList<Book> list=client.getSearchBooks();
		ObservableList<Book>books= FXCollections.observableArrayList(list);
		tableSearchBooks.setItems(books);
		isbnSearchBooks.setCellValueFactory(new PropertyValueFactory<Book, String>("key"));
		rackSearchBooks.setCellValueFactory(new PropertyValueFactory<Book, Integer>("value"));
	}
	
	public void loadTableMyBasket(Book[] h) {
    	basePane.setOnKeyPressed(null);
    	FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion2.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		tableMyBasket.getItems().clear();
		Book[] list=client.getBuyBooks();
		ObservableList<Book>books= FXCollections.observableArrayList(list);
		tableMyBasket.setItems(books);
		isbnMyBasket.setCellValueFactory(new PropertyValueFactory<Book, String>("key"));
		rackMyBasket.setCellValueFactory(new PropertyValueFactory<Book, Integer>("value"));
}
	
	public void refreshTableMyBasket() {
		tableMyBasket.getItems().clear();
		Book[] list=client.getBuyBooks();
		ObservableList<Book>books= FXCollections.observableArrayList(list);
		tableMyBasket.setItems(books);
		isbnMyBasket.setCellValueFactory(new PropertyValueFactory<Book, String>("key"));
		rackMyBasket.setCellValueFactory(new PropertyValueFactory<Book, Integer>("value"));
	}
	
	public void loadTableQue() {
		basePane.setOnKeyPressed(null);
    	FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion2.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		tableMyBasket.getItems().clear();
		Book[] list=client.getBuyBooks();
		ObservableList<Book>books= FXCollections.observableArrayList(list);
		tableMyBasket.setItems(books);
		isbnMyBasket.setCellValueFactory(new PropertyValueFactory<Book, String>("key"));
		rackMyBasket.setCellValueFactory(new PropertyValueFactory<Book, Integer>("value"));
	}
	@FXML
	void startSection1(){
		if(Integer.parseInt(numberOfShelvings.getText()) > 0 && Integer.parseInt(numberCashRegister.getText()) > 0 ) {
		books.put("1229", getRandomShelving() , "IV", "Good story" , "8/10", "Hitman", 129330, 10);
		books.put("1231", getRandomShelving() , "V", "Good characters" , "9/10", "HarryPotter", 130000, 10);
		books.put("1232", getRandomShelving() , "I", "Traumatic" , "7/10", "The King", 100000, 10);
		books.put("1233", getRandomShelving() , "II", "Violence" , "6/10", "The butterfly", 150000, 10);
		books.put("1234", getRandomShelving() , "III", "Good story" , "5/10", "The Jungle", 80000, 10);
		books.put("1235", getRandomShelving() , "X", "Mystery" , "2/10", "ToyStory", 600000, 10);
		books.put("1236", getRandomShelving() , "VI", "Good story" , "3/10", "Batman", 70000, 10);
		books.put("1237", getRandomShelving() , "VII", "Happy" , "9/10", "Gentleman", 150000, 10);
		books.put("1238", getRandomShelving() , "IX", "Mystery" , "10/10", "Agent007", 200000, 10);
		books.put("1239", getRandomShelving() , "V", "Amazing" , "8/10", "GoodPlace", 160000, 10);
		paymentBoxes=new Client[Integer.parseInt(numberCashRegister.getText())];
		loadSection1();
		}
		else {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText("You put any invalid field value");
			a.show();
		}
	}
	
	@FXML
	void goToSection2(){
			try {
				client = new Client(identificationTextField.getText());
				numClients++;
				client.setTime(numClients);
				loadSection2();
			} catch (NoIdentificationException e) {
				Alert a = new Alert(AlertType.WARNING);
				a.setContentText("You need put a identification");
				a.show();
			}
	}
	@FXML
	void addBook() {
		String value = sortByBox.getValue();
		String code = isbnAdd.getText();
		int quantity = Integer.parseInt(quantityAdd.getText());
		if(books.search(code) != null) {
			for(int i =0;i<quantity;i++) {
				if(books.search(code) != null) {
				client.getSearchBooks().add(books.search(code));
				client.setQuantityB(client.getQuantityB()+1);
				books.remove(code);
				}
			}
		}else {
			Alert a = new Alert(AlertType.WARNING);
			a.setContentText("the ISBN was not found, you entered an invalid code or we are out of stock.");
			a.show();
		}
		if(value.equals("BubbleSort")) {
			bubbleSort(client.getSearchBooks());
		}
		
		else if(value.equals("HeapSort")) {
			heapSort(client.getSearchBooks());
		}
		else if (value.equals("MergeSort")){
			mergeSort(client.getSearchBooks());
		}
		refreshTableSearchBook();
	}
	
	@FXML
	void fillMyBasket() {
		int s=client.getSearchBooks().size();
		client.setTime(client.getTime()+s);
		client.fillBuyBooks();
		clients.add(client);
		refreshTableMyBasket();
	}
	public void addQueue() {
		for(int s=0;s<clients.size();s++) {
			clients2.add(clients.get(s).clone());
		}
		for(int s=0;s<clients.size();s++) {
			queue.enqueue(clients.get(s));
		}
	}
	@FXML
	void addOtherClient(){
		loadSection1();
	}
	public void sortClientsList() {
		Collections.sort(clients);
	}
	public void loadQueueTable() {
		basePane.setOnKeyPressed(null);
    	FXMLLoader fxmload = new FXMLLoader(getClass().getResource("Seccion3.fxml"));
		fxmload.setController(this);
		Parent root;
		try {
			root = fxmload.load();
			basePane.getChildren().clear();
			basePane.setCenter(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		tableQueue.getItems().clear();
		ObservableList<Client> c= FXCollections.observableArrayList(clients2);
		tableQueue.setItems(c);
		
		identificationQueue.setCellValueFactory(new PropertyValueFactory<Client, String>("Identification"));
		quantityBooksQueue.setCellValueFactory(new PropertyValueFactory<Client,Integer>("quantityB"));
	}
	public void exitTable() {
		tableExit.getItems().clear();
		ObservableList<Client>c =FXCollections.observableArrayList(updateClients);
		tableExit.setItems(c);
		identificationExit.setCellValueFactory(new PropertyValueFactory<Client, String>("Identification"));
		isbnsBooksExit.setCellValueFactory(new PropertyValueFactory<Client,String>("books"));
		priceExit.setCellValueFactory(new PropertyValueFactory<Client,Integer>("price"));
	}
	@FXML
	void purchase(){
		sortClientsList();
		addQueue();
		numClients=0;
		loadSection3();
	}
	public void paymentBooks() {
		boolean verified;
		for(int s=0;s<paymentBoxes.length;s++) {
			if(queue.front()!=null) {
				if(paymentBoxes[s]==null) {
					paymentBoxes[s]=queue.dequeue();
				}
			}
		}
		verified=counting();
		if(verified) {
			countingAndAdd();
		}
		for(int s=0;s<paymentBoxes.length;s++) {
			if(paymentBoxes[s]==null){
				cont++;
			}
		}
		
		while(cont!=paymentBoxes.length) {
			cont=0;
			paymentBooks();
		}
	}
	public boolean verifiedQuantity() {
		boolean v=false;
		for(int w=0;w<paymentBoxes.length;w++) {
			if(paymentBoxes[w]!=null) {
				if(paymentBoxes[w].getQuantityB()==0) {
					v=true;
				}
			}
		}
		return v;
	}
	public void getFinalReport() {
		for(int s=0;s<updateClients.size();s++) {
			updateClients.get(s).lisOfISBN();
			updateClients.get(s).priceBooks();
		}
	}
	public void countingAndAdd() {
		for(int s=0;s<paymentBoxes.length;s++) {
			if(paymentBoxes[s]!=null) {
				if(paymentBoxes[s].getQuantityB()!=0) {
					paymentBoxes[s].setQuantityB(paymentBoxes[s].getQuantityB()-1);
				}

				else {
					updateClients.add(paymentBoxes[s]);
					paymentBoxes[s]=null;
					if(queue.front()!=null) {
						paymentBoxes[s]=queue.dequeue();
					}
				}
			}
		}
		if(verifiedQuantity()) {
			countingAndAdd();
		}
	}
	public boolean counting() {
		for(int s=0;s<paymentBoxes.length;s++) {
			if(paymentBoxes[s]!=null) {
				paymentBoxes[s].setQuantityB(paymentBoxes[s].getQuantityB()-1);
			}
		}
		boolean verified=verifiedQuantity();
		return verified;
	}
	@FXML
	void finishAndExit() {
		System.exit(0);
	}
	
	int getRandomShelving() {
		int randomNum = ThreadLocalRandom.current().nextInt(1,Integer.parseInt(numberOfShelvings.getText()) + 1);
		return randomNum;
	}
	
	public void bubbleSort(ArrayList<Book> books) {
		Book temp = null;
		for(int i = books.size()-1;i>0;i--) {
			for(int j = 0;j<i; j++) {
				if(books.get(j).getValue()> books.get(j+1).getValue()) {
					temp = books.get(j);
					books.set(j, books.get(j+1));
					books.set(j+1, temp);
				}
			}
		}
	}
	
	public void heapSort(ArrayList<Book> books){ 
        int n = books.size(); 
        for (int i = n / 2 - 1; i >= 0; i--) { 
            heapify(books, n, i); 
    	}
        for (int i=n-1; i>=0; i--){ 
            Book temp = books.get(0); 
            books.set(0,books.get(i));
            books.set(i, temp);
            heapify(books, i, 0); 
        } 
    } 
	private void heapify(ArrayList<Book> books, int n, int i) { 
        int largest = i; 
        int l = 2*i + 1; 
        int r = 2*i + 2;  
        if (l < n && books.get(l).getValue() > books.get(largest).getValue()) {
            largest = l; 
        }
        if (r < n && books.get(r).getValue() > books.get(largest).getValue()) {
            largest = r; 
        }
        if (largest != i){ 
            Book swap = books.get(i); 
            books.set(i, books.get(largest));
            books.set(largest, swap);
            heapify(books, n, largest); 
        } 
    } 
	
	
	public ArrayList<Book> mergeSort(ArrayList<Book> list){
		ArrayList<Book> left = new ArrayList<Book>();
		ArrayList<Book> right = new ArrayList<Book>();
		
		int medium;
		
		if(list.size() == 1) {
			return list;
		}else {
			medium = list.size()/2;
			for(int i = 0 ; i < medium; i++) {
				left.add(list.get(i));
			}
			
			for(int i = medium; i<list.size(); i++) {
				right.add(list.get(i));
			}
			left = mergeSort(left);
			right = mergeSort(right);
			
			merge(left, right, list);
		}
		
		return list;
	}
	
	private void merge(ArrayList<Book> left, ArrayList<Book>right, ArrayList<Book>list) {
		int leftIndex = 0;
		int rightIndex = 0;
		int listIndex = 0;
		
		while(leftIndex < left.size() && rightIndex < right.size()) {
			if(new ValueComparator().compare(left.get(leftIndex), right.get(rightIndex))<0) {
				list.set(listIndex, left.get(leftIndex));
				leftIndex++;
			}else {
				list.set(listIndex, right.get(rightIndex));
				rightIndex++;
			}
			listIndex++;
		}
		ArrayList<Book> temp;
		int tempIndex = 0;
		if(tempIndex>=left.size()) {
			temp = right;
			tempIndex = rightIndex;
		}else {
			temp = left;
			tempIndex = leftIndex;
		}
		for(int i = tempIndex;i<temp.size();i++) {
			list.set(listIndex, temp.get(i));
			listIndex++;
		}
	}
}
