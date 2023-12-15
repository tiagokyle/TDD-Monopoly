package com.example.tddmonopoly;

import java.util.Arrays;
import java.util.Random;

public class Dice {

    private final Random random;

    private int diceTotal;

    private boolean isDouble = false;

    public Dice(Random rand){
        this.random = rand;
    }

    public int[] roll(){
        int[] dice = new int[2];

        dice[0] = random.nextInt(6)+1;
        dice[1] = random.nextInt(6)+1;

        if (dice[0] == dice[1]){
            setDiceDouble(true);
        }

        diceTotal = Arrays.stream(dice).sum();
        return dice;
    }

    public boolean isDouble() {
        return isDouble;
    }

    public void setDiceDouble(boolean setDice) {
        isDouble = setDice;
    }

    public int getDiceTotal() {
        return diceTotal;
    }
}
