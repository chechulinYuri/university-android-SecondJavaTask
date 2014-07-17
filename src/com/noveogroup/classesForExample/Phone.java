package com.noveogroup.classesForExample;

/**
 * Created by Yuri on 16.07.2014.
 */
public class Phone extends Product implements TechValue {

    public Phone(int price) {
        super(price);
    }

    @Override
    public int getElectricityConsumption() {
        return 0;
    }
}
