package com.company;
import java.util.Scanner;

public class Player {
    private String name;
    private int type;
    private int currentChoice;
    public int answer;
    public int score = 0;


    public int getChoice() {
        return this.currentChoice;
    }

    public void setChoice(int choice)
    {
        this.currentChoice = choice;
    }


    public int getScore() {
        return this.score;
    }

    public void incrementScore() {
        this.score += 1;
    }


    public static Boolean gameOver = false;
    Scanner scanner = new Scanner(System.in);


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public int getType()
    {
        return this.type;
    }




    public void inputName() {
        System.out.println("Enter your name!");
        name = scanner.next();
    }


    // Displays who is throwing what
    public static void selection(String thrower, int thrown) {
        if (thrown == Game.rock) {
            System.out.println(thrower + " has thrown Rock! ");
        } else if (thrown == Game.paper) {
            System.out.println(thrower + " has thrown Paper! ");
        } else if (thrown == Game.scissors) {
            System.out.println(thrower + " has thrown Scissors! ");
        } else {

        }
    }

}
