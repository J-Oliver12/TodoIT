package org.example;

import org.example.model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class App {
    public static void main( String[] args ){

        Person person1 = new Person("Juan", "Oliver", "test@tesson.se");
        Person person2 = new Person("John", "Doe", "test1@tesson1.se");
        Person person3 = new Person("Janne", "Jannson", "test2@tesson3.se");

        /*
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
*/
/*
        System.out.println(person1.getSummary());
        System.out.println(person2.getSummary());
        System.out.println(person3.getSummary());

 */

        TodoItem task1 = new TodoItem("Review methods", "Debug code", LocalDate.of(2023, 8, 31), person1);
        TodoItem task2 = new TodoItem("Review web design", "Write HTML part", LocalDate.of(2023, 8, 24), person2);
        TodoItem task3 = new TodoItem("Review CSS", "Improve Fonts", LocalDate.of(2023, 8, 30), person3);

        /*
        System.out.println("##############################################################################");
        System.out.println(task1);
        System.out.println("##############################################################################");
        System.out.println(task2);
        System.out.println("##############################################################################");
        System.out.println(task3);
*/
/*
        System.out.println(task1.getSummary());
        System.out.println(task2.getSummary());
        System.out.println(task3.getSummary());
*/


        TodoItemTask Item1 = new TodoItemTask(true, task1, person1);
        TodoItemTask Item2 = new TodoItemTask(true, task2, person2);
        TodoItemTask Item3 = new TodoItemTask(true, task3, person3);

        /*
        System.out.println("##############################################################################");
        System.out.println(Item1);
        System.out.println("##############################################################################");
        System.out.println(Item2);
        System.out.println("##############################################################################");
        System.out.println(Item3);
        */


        /*
        System.out.println(Item1.getSummary());
        System.out.println(Item2.getSummary());
        System.out.println(Item3.getSummary());
        */

        AppUser user1 = new AppUser("Juan", "test123", AppRole.ROLE_APP_ADMIN);
        AppUser user2 = new AppUser("John", "test456", AppRole.ROLE_APP_USER);
        AppUser user3 = new AppUser("Janne", "test789", AppRole.ROLE_APP_USER);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        System.out.println("\n##############################################################################\n");

        System.out.println(Item1);
        System.out.println(Item2);
        System.out.println(Item3);

        System.out.println("\n##############################################################################\n");

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user3.hashCode());

        System.out.println("\n##############################################################################\n");


        System.out.println(person1);
        System.out.println(person1.hashCode());
        System.out.println(person1.getCredentials());

        System.out.println(user1);

        System.out.println("\n##############################################################################\n");

        System.out.println(person2);
        System.out.println(person2.hashCode());
        System.out.println(person2.getCredentials());

        System.out.println(user2);

        System.out.println("\n##############################################################################\n");

        System.out.println(person3);
        System.out.println(person3.hashCode());
        System.out.println(person3.getCredentials());

        System.out.println(user3);

        System.out.println("\n##############################################################################\n");








    }

}
