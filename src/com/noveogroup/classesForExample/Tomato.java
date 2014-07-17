package com.noveogroup.classesForExample;

/**
 * Created by Yuri on 16.07.2014.
 */
public class Tomato extends Product implements FoodValue {

    public Tomato(int price) {
        super(price);
    }

    @Override
    public int getProteins() {
        return 0;
    }

    @Override
    public int getFats() {
        return 0;
    }

    @Override
    public int getCarbo() {
        return 0;
    }
}
