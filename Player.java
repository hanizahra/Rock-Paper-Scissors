package com.company;
import java.util.Scanner;

public class Player {
    private String name;
    private int type;
    private int currentChoice;
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


}
