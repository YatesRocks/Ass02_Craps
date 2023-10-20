package org.yates.craps;

import java.util.Random;

public class Roll {
    private final int firstDice;
    private final int secondDice;

    public Roll() {
        System.out.println("Rolling the dice...");
        Random rd = new Random();
        this.firstDice = rd.nextInt(6) + 1;
        System.out.println("First dice is... " + firstDice + "!!!");
        this.secondDice = rd.nextInt(6) + 1;
        System.out.println("Second dice is... " + secondDice + "!!!");
        System.out.println("Looks like your total is " + getPoint());
    }

    public int getPoint() {
        return firstDice + secondDice;
    }
}
