package ui;

import java.util.Scanner;
import collections.LinkedList;
import model.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int value=1;

        for (int i = 0; i < cases; i++) {

            int cashiers = sc.nextInt();
            int shelves = sc.nextInt();
            LinkedList<Shelve> shelvesList = new LinkedList<Shelve>();

            for (int j = 0; j < shelves; j++) {

                String id = sc.next();
                int games = sc.nextInt();
                LinkedList<Game> gamesList = new LinkedList<Game>();

                for (int k = 0; k < games; k++) {
                    
                    gamesList.add(new Game(sc.nextInt(), sc.nextInt(), sc.nextInt(),value++));
                }

                shelvesList.add(new Shelve(id, games, gamesList));

            }

            LinkedList<Customer> customersList = new LinkedList<>();
            int customers = sc.nextInt();
            sc.nextLine();
            for (int j = 0; j < customers; j++) {

                String[] line = sc.nextLine().split(" ");
                int id_customer = Integer.parseInt(line[0]);
                LinkedList<Integer> list = new LinkedList<>();
                for (int k = 1; k < line.length; k++) {
                    list.add(Integer.parseInt(line[k]));
                }

                customersList.add(new Customer(id_customer, list));

            }

            GameStore gameStore = new GameStore(cashiers, shelvesList, customersList);


            System.out.println(gameStore.toStringShelves());

            System.out.println(gameStore.section1());




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
