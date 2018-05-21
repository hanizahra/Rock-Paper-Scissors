package com.company;
import java.util.Scanner;
import java.util.Random;

public class Game {

    public static int rock = 1;
    public static int paper = 2;
    public static int scissors = 3;
    protected Player firstPlayer;
    protected Player secondPlayer;



    public Game() {
        this.firstPlayer = new Player();
        this.secondPlayer = new Player();
    }


    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Best of 5 wins. Ok, let's play...");

        System.out.println("First player name:");
        String firstPlayerName = scanner.next();
        this.firstPlayer.setName(firstPlayerName);
        this.firstPlayer.setType(1);


        //get the the second players name
        //get the second players type -- human/computer
        System.out.println("Select 2nd player type(1=human, 2=computer)");
        int secondPlayerType = scanner.nextInt();
        secondPlayer.setType(secondPlayerType);
        if(secondPlayerType == 1) {
           System.out.println("Second player name:");
           String secondPlayerName = scanner.next();
           this.secondPlayer.setName(secondPlayerName);
        }
        else {
           this.secondPlayer.setName("Computer");
        }


        while(true) {

            int firstPlayerChoice = this.doChoice(this.firstPlayer.getType());
            this.firstPlayer.setChoice(firstPlayerChoice);

            int secondPlayerChoice = this.doChoice(this.secondPlayer.getType());
            this.secondPlayer.setChoice(secondPlayerChoice);


            int playerWhoWon = this.whoWon();

            switch(playerWhoWon) {
                case 1:
                    System.out.println(this.firstPlayer.getName() + " won the round!");
                    this.firstPlayer.incrementScore();
                    break;
                case 2:
                    System.out.println(this.secondPlayer.getName() + " won the round!");
                    this.secondPlayer.incrementScore();
                    break;
                case 0:
                    System.out.println("Game was a draw!");
                    break;
                default:
                    break;
            }
            System.out.println("");
            this.displayScore();
            System.out.println("");
            if(this.isGameOver()) {
                this.displayWinner();
                break;
            }
        }
    }

    public void displayWinner() {
        if(this.firstPlayer.getScore() == 3) {
            System.out.println(this.firstPlayer.getName() + " won the game!");
        }
        else if(this.secondPlayer.getScore() == 3) {
            System.out.println(this.secondPlayer.getName() + " won the game!");
        }
    }

    public int doChoice(int playerType) {
        int choice = 0;
        if (playerType == 1) {
            choice = this.promptUserForChoice();
        }
        else if(playerType == 2) {
            choice = this.generateComputerChoice();
        }
        return choice;
    }


    public int promptUserForChoice() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Rock, Paper, or Scissors?");
            String input = scanner.next();
            input = input.toLowerCase();
            char x = input.charAt(0);

            if (x == 'r') {
                return Game.rock;
            } else if (x == 'p') {
                return Game.paper;
            } else if (x == 's') {
                return Game.scissors;
            } else {
                System.out.println("Invalid input. Try again...");
            }
        }
    }

     public int generateComputerChoice() {
        Random random = new Random();
        int n = random.nextInt(3) + 1;
        return n;
    }

    /**
     *
     * @return int
     *
     * accepts two players as input, compares their choices and returns the number
     * of the player who won
     * 0 = draw
     * 1 = first player
     * 2 = second player
     *
     */

    public int whoWon() {

        if (this.firstPlayer.getChoice() == this.secondPlayer.getChoice()) {
            return 0;
        }
        switch (this.firstPlayer.getChoice()) {
            case 1: //rock
                if (this.secondPlayer.getChoice() == Game.paper) {
                    System.out.println("Paper beats Rock -- ");
                } else if (this.secondPlayer.getChoice() == Game.scissors) {
                    System.out.println("Rock beats Scissors -- ");
                }
                //System.out.println("Paper beats Rock -- ");
                return (this.secondPlayer.getChoice() == Game.paper ? 2 : 1);
            case 2: //paper
                if (this.secondPlayer.getChoice() == Game.rock) {
                    System.out.println("Paper beats Rock -- ");
                } else if (this.secondPlayer.getChoice() == Game.scissors) {
                    System.out.println("Scissors beats Paper -- ");
                }
                //System.out.println("Scissors beats Paper -- ");
                return (this.secondPlayer.getChoice() == Game.scissors ? 2 : 1);
            case 3: //scissors
                if (this.secondPlayer.getChoice() == Game.rock) {
                    System.out.println("Rock beats Scissors -- ");
                } else if (this.secondPlayer.getChoice() == Game.paper) {
                    System.out.println("Scissors beats Paper -- ");
                }
                //System.out.println("Rock beats Scissors -- ");
                return (this.secondPlayer.getChoice() == Game.rock ? 2 : 1);
            default:
                return 0;
        }


    }

    public boolean isGameOver() {
        if (this.firstPlayer.getScore() == 3 || this.secondPlayer.getScore() == 3) {
            return true;
        } else {
            return false;
        }
    }

    public void displayScore() {
        System.out.println(this.firstPlayer.getName() + " has " + this.firstPlayer.getScore() + " points");
        System.out.println(this.secondPlayer.getName() + " has " + this.secondPlayer.getScore() + " points");
    }

}
