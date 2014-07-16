package com.noveogroup.tree;

import com.noveogroup.model.Element;
import com.noveogroup.classesForExample.*;

import java.util.Iterator;

/**
 * Sample implementation.
 */
public class BinaryTreeImpl<K extends Integer, V extends Product> implements BinaryTree<K,V> {

    public Element root;
    private MineIterator<Element> iter;

    @Override
    public void print() {
        print(root);
    }

    @Override
    public void print(Element node) {
        if (node == null) {
            return;
        }

        print(node.getLeft());
        System.out.println(node.getKey());
        print(node.getRight());
    }

    @Override
    public Element getRoot() {
        return root;
    }

    @Override
    public void addElement(K key, V element) {
        // TODO
        if (root == null) {
            root = new Element<K, V>(key, element, null);
            return;
        }
        if (key.compareTo(root.getKey()) >= 0) {
            addElement(key, element, root.getRight(), root, true);
        } else {
            addElement(key, element, root.getLeft(), root, false);
        }
    }

    @Override
    public void addElement(K key, V element, Element curr, Element precurr, boolean right) {
        if (curr == null) {
            curr = new Element<K, V>(key, element, precurr);
            if (right) precurr.setRight(curr);
            else precurr.setLeft(curr);
        } else {
            if (key.compareTo(curr.getKey()) >= 0) {
                addElement(key, element, curr.getRight(), curr, true);
            } else {
                addElement(key, element, curr.getLeft(), curr, false);
            }
        }
    }

    @Override
    public void removeElement(K key) {
        //TODO
    }

    @Override
    public Iterator<Element> getIterator() {
        //TODO
        return iter;
    }
}
