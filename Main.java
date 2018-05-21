package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {

            displayMainMenu();
            String menuChoice = scanner.next().toLowerCase();

            switch(menuChoice) {
                case "play":
                    Game newGame = new Game();
                    newGame.start();
                    break;
                case "history":
                    System.out.println("To be done");
                    break;
                case "quit":
                    return;
            }
        }
    }

    public static void displayMainMenu() {
        System.out.println("*** Welcome to Rock Paper Scissors! ***");
        System.out.println("");
        System.out.println("MAIN MENU\n" +
                "=====\n" +
                "1. Type 'play' to play\n" +
                "2. Type 'quit' to stop playing");
    }
}
