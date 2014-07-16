package com.noveogroup.tree;

import com.noveogroup.model.TreeElement;

import java.util.Iterator;

/**
 * Sample implementation.
 */
public class BinaryTreeImpl<K, V extends TreeElement> implements BinaryTree<K,V> {

    private ElementTest root;

    @Override
    public void addElement(K key, V element) {
        if (root.equals(null)) {
            root = new ElementTest(key, element);
            return;
        }
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

    public class ElementTest {
        K key;
        V value;
        ElementTest l;
        ElementTest r;

        ElementTest(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
