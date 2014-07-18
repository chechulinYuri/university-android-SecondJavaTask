package com.noveogroup.tree;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.exception.ElementAlreadyExistsException;
import com.noveogroup.exception.ElementNotExistException;
import com.noveogroup.model.Element;
import com.noveogroup.classesForExample.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Sample implementation.
 */
public class BinaryTreeImpl<K extends Comparable, V extends Product> implements BinaryTree<K,V>, Serializable {

    public Element root;
    private int foliageCount;

    @Override
    public void addElement(K key, V element) throws BinaryTreeException {
        if (root == null) {
            root = new Element<K, V>(key, element);
            return;
        }
        if (key.compareTo(root.getKey()) == 0) {
            throw new ElementAlreadyExistsException();
        } else if (key.compareTo(root.getKey()) > 0) {
            addElement(key, element, root.getRight(), root, true);
        } else {
            addElement(key, element, root.getLeft(), root, false);
        }
    }

    private void addElement(K key, V element, Element curr, Element precurr, boolean right)  throws BinaryTreeException {
        if (curr == null) {
            curr = new Element<K, V>(key, element);
            if (right) precurr.setRight(curr);
            else precurr.setLeft(curr);
        } else {
            if (key.compareTo(curr.getKey()) == 0) {
                throw new ElementAlreadyExistsException();
            } else if (key.compareTo(curr.getKey()) > 0) {
                addElement(key, element, curr.getRight(), curr, true);
            } else {
                addElement(key, element, curr.getLeft(), curr, false);
            }
        }
    }

    @Override
    public void removeElement(K key) throws BinaryTreeException {
        removeElement(key, root);
    }

    private Element removeElement(K key, Element node) throws BinaryTreeException {
        if( node == null ) {
            throw new ElementNotExistException();
        } else if( key.compareTo( node.getKey() ) < 0 ) {
            node.setLeft( removeElement(key, node.getLeft()) );
        } else if( key.compareTo( node.getKey() ) > 0 )
            node.setRight(removeElement( key, node.getRight() ));
        else {
            if (node.getRight() == null) {
                node = node.getLeft();
            } else {
                K tmp = (K) findMin(node.getRight()).getKey();
                node.setKey(tmp);
                node.setRight(removeElement(tmp, node.getRight()));
            }
        }
        return node;
    }

    private Element findMin( Element node ) {
        if( node == null )
            return null;
        else if( node.getLeft() == null )
            return node;
        return findMin( node.getLeft() );
    }

    @Override
    public Iterator<V> getIterator() {
        List<V> list = new ArrayList<V>();
        convertTreeIntoList(root, list);
        return list.iterator();
    }

    private void recalculateFoliageCount(Element node) {
        if (node.getLeft() != null) {
            recalculateFoliageCount(node.getLeft());
        }
        if (node.getLeft() == null && node.getRight() == null) {
            foliageCount++;
        }
        if (node.getRight() != null) {
            recalculateFoliageCount(node.getRight());
        }
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();

        foliageCount = 0;
        recalculateFoliageCount(root);
        stream.writeInt(foliageCount);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        foliageCount = stream.readInt();
    }

    private void convertTreeIntoList(Element node, List list) {
        if (node.getLeft() != null) {
            convertTreeIntoList(node.getLeft(), list);
        }
        list.add((V) node.getValue());
        if (node.getRight() != null) {
            convertTreeIntoList(node.getRight(), list);
        }
    }

    public int getFoliageCount() {
        return foliageCount;
    }

}
