package com.noveogroup.main;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.classesForExample.*;
import com.noveogroup.model.Element;
import com.noveogroup.tree.BinaryTree;
import com.noveogroup.tree.BinaryTreeImpl;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {

        //create BinaryTree
        BinaryTree<Integer, Product> tree = new BinaryTreeImpl<Integer, Product>();

        try {
            //add elements
            tree.addElement(15, new Tomato(340));
            tree.addElement(10, new Tomato(250));
            tree.addElement(110, new Phone(9900));
            tree.addElement(120, new Phone(32000));
            tree.addElement(80, new Tomato(180));
            tree.addElement(1, new Product(999));

            printTree(tree);

            // remove element
            tree.removeElement(110);

            printTree(tree);

        } catch (BinaryTreeException e) {
            //handle the exception
        }
    }

    public static void printTree(BinaryTree tree) {

        // use iterator

        System.out.println("====");

        Iterator<Element> iterator = tree.getIterator();
        while (iterator.hasNext()) {
            Element next = iterator.next();
            System.out.println("Key: " + next.getKey() + "; Product price: " + next.getValue().getPrice());
        }

        System.out.println("====");
    }
}
