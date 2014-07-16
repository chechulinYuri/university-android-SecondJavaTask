package com.noveogroup.main;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.classesForExample.*;
import com.noveogroup.model.TreeElement;
import com.noveogroup.tree.BinaryTree;
import com.noveogroup.tree.BinaryTreeImpl;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        //You can check your implementation here.
        //For example:

        //create BinaryTree
        BinaryTree<Integer, Product> tree = new BinaryTreeImpl<Integer, Product>();
        try {
            //add element
            tree.addElement(10, new Product());
            //remove element
            tree.removeElement(10);
            //get iterator
            Iterator<Product> iterator = tree.getIterator();
            while (iterator.hasNext()) {
                Product next = iterator.next();
                System.out.println(next);
            }
        } catch (BinaryTreeException e) {
            //handle the exception
        }
    }
}
