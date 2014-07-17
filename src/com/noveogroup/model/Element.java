package com.noveogroup.model;

import com.noveogroup.classesForExample.*;

/**
 * Created by Yuri on 16.07.2014.
 */
public class Element<K extends Integer, V extends Product> implements TreeElement {
    private K key;
    private V value;
    private Element l;
    private Element r;

    public Element(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public Element getLeft() {
        return l;
    }

    public Element getRight() {
        return r;
    }

    public void setLeft(Element element) {
        l = element;
    }

    public void setRight(Element element) {
        r = element;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }
}