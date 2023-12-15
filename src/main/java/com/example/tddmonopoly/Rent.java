package com.example.tddmonopoly;

public class Rent {
    public int zero;
    public int one;
    public int two;
    public int three;

    public int four;
    public int hotel;

    public Rent(int zero, int one, int two, int three, int four, int hotel) {
        this.zero = zero;
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
        this.hotel = hotel;
    }

    public int getZero() {
        return zero;
    }


    public int getOne() {
        return one;
    }


    public int getTwo() {
        return two;
    }


    public int getThree() {
        return three;
    }


    public int getFour() {
        return four;
    }


    public int getHotel() {
        return hotel;
    }


    @Override
    public String toString() {
        return zero+ "\nOne house: "+
                one+ "\nTwo houses: "+
                two+ "\nThree houses: "+
                three+ "\nFour houses: "+
                four+ "\nHotel: "+
                hotel;
    }
}
