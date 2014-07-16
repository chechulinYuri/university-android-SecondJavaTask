package com.noveogroup.model;

/**
 * Created by Yuri on 16.07.2014.
 */
public class Element<K, V> implements TreeElement {
    K key;
    V value;
    Element l;
    Element r;

    public Element(K key, V value) {
        this.key = key;
        this.value = value;
    }
}