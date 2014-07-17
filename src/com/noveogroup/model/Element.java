package com.noveogroup.model;

/**
 * Created by Yuri on 16.07.2014.
 */
public class Element<K extends Integer, V> implements TreeElement {
    private K key;
    private V value;
    private Element l;
    private Element r;
    private Element parent;

    public Element(K key, V value, Element parent) {
        this.key = key;
        this.value = value;
        this.parent = parent;
    }

    public K getKey() {
        return key;
    }

    public V getValue() { return value; }

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

    public void setValue(V value) {
        this.value = value;
    }

}