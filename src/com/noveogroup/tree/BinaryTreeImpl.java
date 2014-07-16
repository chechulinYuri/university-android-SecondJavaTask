package com.noveogroup.tree;

import com.noveogroup.model.Element;
import com.noveogroup.classesForExample.*;

import java.util.Iterator;

/**
 * Sample implementation.
 */
public class BinaryTreeImpl<K, V extends Product> implements BinaryTree<K,V> {

    private Element root;

    @Override
    public void addElement(K key, V element) {
        // TODO
        /*if (root.equals(null)) {
            root = new Element<K, V>(key, element);
            return;
        }*/
    }

    @Override
    public void removeElement(K key) {
        //TODO
    }

    @Override
    public Iterator<V> getIterator() {
        //TODO
        return null;
    }
}
