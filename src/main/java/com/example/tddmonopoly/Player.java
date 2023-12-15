package com.example.tddmonopoly;

import java.util.List;

public class Player {
    private String name;
    private int moneyBalance;
    private int position;
    private final List<Street> propertiesOwned;

    public Player(String name, int moneyBalance, int position, List<Street> propertiesOwned) {
        this.name = name;
        this.moneyBalance = moneyBalance;
        this.position = position;
        this.propertiesOwned = propertiesOwned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(int moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<Street> getPropertiesOwned() {
        return propertiesOwned;
    }

    public void addPropertiesOwned(Street userProperty) {
        propertiesOwned.add(userProperty);
    }
}
