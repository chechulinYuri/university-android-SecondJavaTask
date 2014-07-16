package com.noveogroup.tree;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.model.Element;

import java.util.Iterator;

/**
 * Binary tree interface. Please add your exceptions to methods.
 */
public interface BinaryTree <K,V> {
    Element getRoot();
    void addElement(K key, V element) throws BinaryTreeException;
    void addElement(K key, V element, Element curr, Element precurr, boolean right) throws BinaryTreeException;
    void removeElement(K key) throws BinaryTreeException;
    void print(Element node);
    void print();
    Iterator<Element> getIterator();
}
