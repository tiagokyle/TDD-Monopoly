package com.example.tddmonopoly;

import java.util.Comparator;
import java.util.Objects;

public class Street {
    public int id;
    public String colourGroup;
    public String streetName;

    public int price;
    public Rent rent;
    public int mortgage;
    public int upgradeCost;
    public String owner;

    public Street(int id, String colourGroup, String streetName, int price, Rent rent, int mortgage, int upgradeCost) {
        this.id = id;
        this.colourGroup = colourGroup;
        this.streetName = streetName;
        this.price = price;
        this.rent = rent;
        this.mortgage = mortgage;
        this.upgradeCost = upgradeCost;
    }

    public int getId() {
        return id;
    }


    public String getColourGroup() {
        return colourGroup;
    }


    public String getStreetName() {
        return streetName;
    }


    public int getPrice() {
        return price;
    }


    public Rent getRent() {
        return Objects.requireNonNullElseGet(rent, () -> new Rent(0,0,0,0,0,0));
    }

    public int getMortgage() {
        return mortgage;
    }

    public int getUpgradeCost() {
        return upgradeCost;
    }


    public String getOwner() {
        return Objects.requireNonNullElse(owner, "No owner!");
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public static Comparator<Street> StreetID = new Comparator<Street>() {
        @Override
        public int compare(Street o1, Street o2) {
            int streetID1 = o1.getId();
            int streetID2 = o2.getId();

            return streetID1 - streetID2;
        }
    };

    @Override
    public String toString() {
        return streetName + "\nPrice: " +
                price + "\nRent: " +
                getRent() + "\nUpgrade Cost: " +
                upgradeCost + "\nMortgage Value: " +
                mortgage + "\nOwner: " +
                getOwner();

    }

}
