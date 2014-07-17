package com.noveogroup.main;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.classesForExample.*;
import com.noveogroup.model.Element;
import com.noveogroup.tree.BinaryTree;
import com.noveogroup.tree.BinaryTreeImpl;
import java.io.*;
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
            tree.addElement(11, new Product(9999));
            //tree.addElement(1, new Product(9999)); // Row with AlreadyExistException

            printTree(tree);

            // remove element
            tree.removeElement(110);
            // tree.removeElement(1100); // Row with NotExistException

            printTree(tree);

            String path = System.getProperty("user.dir") + "/folder.txt";
            FileInputStream in = null;
            FileOutputStream out = null;

            in = new FileInputStream(path);
            out = new FileOutputStream(path);

            ObjectOutputStream outo = new ObjectOutputStream(out);
            ObjectInputStream ino = new ObjectInputStream(in);

            outo.writeObject(tree);

            BinaryTree newTree = (BinaryTree) ino.readObject();

            printTree(newTree);
            System.out.println(newTree.getFoliageCount());

        } catch (BinaryTreeException e) {
            System.out.println("EXCEPTION: " + e.toString());
        } catch (FileNotFoundException e) {
            System.out.println("EXCEPTION: " + e.toString());
        } catch (IOException e) {
            System.out.println("EXCEPTION: " + e.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("EXCEPTION: " + e.toString());
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
