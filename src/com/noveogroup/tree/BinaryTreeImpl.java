package com.noveogroup.tree;

import com.noveogroup.exception.BinaryTreeException;
import com.noveogroup.model.Element;
import com.noveogroup.classesForExample.*;

import java.util.Iterator;
import java.util.Stack;

/**
 * Sample implementation.
 */
public class BinaryTreeImpl<K extends Integer, V extends Product> implements BinaryTree<K,V> {

    public Element root;

    @Override
    public void addElement(K key, V element) {
        if (root == null) {
            root = new Element<K, V>(key, element);
            return;
        }
        if (key.compareTo(root.getKey()) >= 0) {
            addElement(key, element, root.getRight(), root, true);
        } else {
            addElement(key, element, root.getLeft(), root, false);
        }
    }

    private void addElement(K key, V element, Element curr, Element precurr, boolean right) {
        if (curr == null) {
            curr = new Element<K, V>(key, element);
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
    public void removeElement(K key) throws BinaryTreeException {
        try {
            removeElement(key, root);
        } catch(BinaryTreeException e) {
            System.out.println(e.toString());
        }
    }

    private Element removeElement(K key, Element node) throws BinaryTreeException {
        if( node == null ) {

        } else if( key.compareTo( node.getKey() ) < 0 ) {
            node.setLeft( removeElement(key, node.getLeft()) );
        }
        else if( key.compareTo( node.getKey() ) > 0 )
            node.setRight(removeElement( key, node.getRight() ));
        else
        {
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
    public Iterator<Element> getIterator() {
        return new MineIterator<Element>();
    }

    public class MineIterator<T extends Element> implements Iterator <T> {

        private Stack<T> stk = new Stack<T>();

        public MineIterator() {
            if(root != null) stk.push((T) root);
        }

        @Override
        public boolean hasNext() {
            return !stk.isEmpty();
        }

        @Override
        public T next() {
            T cur = stk.peek();
            if(cur.getLeft() != null) {
                stk.push((T) cur.getLeft());
            }
            else {
                T tmp = stk.pop();
                while( tmp.getRight() == null ) {
                    if(stk.isEmpty()) return cur;
                    tmp = stk.pop();
                }
                stk.push((T) tmp.getRight());
            }

            return cur;
        }

        @Override
        public void remove() {

        }
    }
}
