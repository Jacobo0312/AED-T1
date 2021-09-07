package ui;

import collections.QueueList;
import collections.StackList;
import model.*;

public class Main {

    public static void main(String[] args) {

        Person test1 = new Person("Daniel", "1006107372", 2);
        Person test2 = new Person("Daniela", "5475474745", 19);
        Person test3 = new Person("Esteban", "5447457457", 18);
        Person test4 = new Person("Jacobo", "124107372", 18);
        Person test5 = new Person("Alex", "547999898", 19);
        Person test6 = new Person("Camilo", "1107123372", 1);

        System.out.println(test4.compareTo(test5));

        QueueList<Person> list = new QueueList<Person>();

        list.enqueue(test1);
        list.enqueue(test2);
        list.enqueue(test3);
        list.enqueue(test4);
        list.enqueue(test5);
        list.enqueue(test6);

        toString(list);

    }

    public static void toString(QueueList<Person> list) {
        System.out.println("LISTA:");
        while (!list.isEmpty()) {
            System.out.println(list.dequeue());
        }
        System.out.println("-----------------------------------------");

    }

}
