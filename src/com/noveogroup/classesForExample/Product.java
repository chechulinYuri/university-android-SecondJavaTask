package com.noveogroup.classesForExample;

import java.io.Serializable;

/**
 * Created by Yuri on 16.07.2014.
 */
public class Product implements ProductValue, Serializable {

    private int price;

    public Product(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }
}
