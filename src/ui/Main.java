package ui;

import java.util.Scanner;
import collections.LinkedList;
import model.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int valueTotal = 0;

        for (int i = 0; i < cases; i++) {

            int cashiers = sc.nextInt();
            int shelves = sc.nextInt();
            LinkedList<Shelve> shelvesList = new LinkedList<Shelve>();
            LinkedList<Game> games = new LinkedList<Game>();

            for (int j = 0; j < shelves; j++) {

                

                String id = sc.next();
                int gamesForShelve = sc.nextInt();
                LinkedList<Game> gamesList = new LinkedList<Game>();

                valueTotal+=gamesForShelve;
                int value=valueTotal;

                for (int k = 0; k < gamesForShelve; k++) {

                    Game game = new Game(sc.nextInt(), sc.nextInt(), sc.nextInt(), value--);
                    gamesList.add(game);
                    games.add(game);
                }

                shelvesList.add(new Shelve(id, gamesForShelve, gamesList));

            }

            LinkedList<Customer> customersList = new LinkedList<>();
            int customers = sc.nextInt();
            sc.nextLine();
            int time = 1;
            for (int j = 0; j < customers; j++) {

                String[] line = sc.nextLine().split(" ");
                int id_customer = Integer.parseInt(line[0]);
                LinkedList<Integer> list = new LinkedList<>();
                for (int k = 1; k < line.length; k++) {
                    list.add(Integer.parseInt(line[k]));
                }

                customersList.add(new Customer(id_customer, list, time++));

            }

            GameStore gameStore = new GameStore(cashiers, shelvesList, customersList, games);

            System.out.println(gameStore.toStringShelves());

            // SECTION 1 IT WORKS
            System.out.println(gameStore.section1());

            // SECTION 2 IT WORKS
            System.out.println(gameStore.section2());

            // SECTION 3 IT WORKS
            System.out.println(gameStore.section3());


        }

        sc.close();
    }

}

/*
 * La primera línea es la cantidad de casos de prueba.
 * 
 * Luego, la primera línea tiene la cantidad de cajeros disponibles durante el
 * día. La segunda línea presenta la cantidad de estanterías. Para cada
 * estantería está la primera línea con su identificador y un número j de juegos
 * en dicha sección. Después hay j líneas cada una de ellas con un primer número
 * que indica el código de identificación del juego, un segundo que es el precio
 * y el tercero que indica la cantidad de ejemplares.
 * 
 * 
 * Posteriormente, en la siguiente línea después de terminar con las
 * estanterías, aparece el número c de clientes que ingresan a la tienda durante
 * la jornada.
 * 
 * Finalmente aparecen c líneas en donde el primer número indica la cédula del
 * cliente y le siguen los números que identifican los códigos de los juegos a
 * comprar.
 */
