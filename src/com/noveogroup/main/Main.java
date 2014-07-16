package com.noveogroup.main;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.classesForExample.*;
import com.noveogroup.tree.BinaryTree;
import com.noveogroup.tree.BinaryTreeImpl;

public class Main {
    public static void main(String[] args) {
        //You can check your implementation here.
        //For example:

        //create BinaryTree
        BinaryTree<Integer, Product> tree = new BinaryTreeImpl<Integer, Product>();
        try {
            //add elements
            tree.addElement(15, new Tomato());
            tree.addElement(10, new Tomato());
            tree.addElement(110, new Phone());
            tree.addElement(120, new Phone());
            tree.addElement(80, new Tomato());
            tree.addElement(1, new Product());

            //remove element
            //tree.removeElement(10);

            tree.print();

            //get iterator
            /*Iterator<Product> iterator = tree.getIterator();
            while (iterator.hasNext()) {
                Product next = iterator.next();
                System.out.println(next);
            }*/
        } catch (BinaryTreeException e) {
            //handle the exception
        }
    }
}
