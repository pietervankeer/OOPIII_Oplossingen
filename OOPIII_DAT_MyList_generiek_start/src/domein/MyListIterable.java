package domein;

import exceptions.EmptyListException;

import java.io.Serializable;
import java.util.Iterator;

public class MyListIterable<T extends Serializable> implements Iterable<T>, Serializable {
    
    private Node<T>  firstNode;
    private Node<T> lastNode;
    private String nameList;

    public MyListIterable() {
        this("List");
    }

    public MyListIterable (String name) {
        nameList = name;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

 @Override
    public String toString() {
        if (isEmpty()) {
            return nameList + " is empty";
        }

        StringBuilder buffer = new StringBuilder();
        buffer.append("The ").append(nameList).append(" is: ");

        this.forEach(elem -> buffer.append(elem).append(" "));
        return buffer.toString();
    }

    public void insertAtFront(T data) {
        Node<T> aNode = new Node<T>(data);
        if (isEmpty()) {
            firstNode = lastNode = aNode;
        } else {
            aNode.setNext(firstNode);
            firstNode = aNode;
        }
    }

    public void insertAtBack(T data) {
        Node<T> aNode = new Node<T>(data);
        if (isEmpty()) {
            firstNode = lastNode = aNode;
        } else {
            lastNode.setNext(aNode);
            lastNode = (Node<T>) lastNode.getNext();
        }
    }

    public T removeFromFront() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException(nameList);
        }

        T removedItem = firstNode.getData();
        if (firstNode == lastNode) {
            firstNode = lastNode = null;
        } else {
            firstNode = firstNode.getNext();
        }

        return removedItem;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }
   
    private class MyIterator implements Iterator<T> {
        
        private Node<T> current = MyListIterable.this.firstNode;

        @Override
        public boolean hasNext() {return current != null;
        }

        @Override
        public T next() {
            T data = current.getData();
            current = current.getNext();
            return data; 
        }
    }

}