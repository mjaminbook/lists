package org.macalester.edu.comp124.lists;

/**
 * An unfinished implementation of a basic doubly-linked list.
 * <p/>
 * <p/>
 * <p/>
 * Note that the head and the tail contain "sentinel" nodes without values.
 * <p/>
 * This makes the edge cases of the algorithm easier because the list always has a discrete head and tail.
 *
 * @param <E>
 * @author shilad
 */

public class MyLinkedList<E> {

    private MyLinkedNode<E> head;

    private MyLinkedNode<E> tail;

    protected int numElements;


    /**
     * Creates a new empty linked list.
     */

    public MyLinkedList() {

        head = new MyLinkedNode<E>(null);

        tail = new MyLinkedNode<E>(null);

        numElements = 0;

        clear();

    }


    /**
     * Returns the element at position index.
     *
     * @param index
     * @return
     */

    public E get(int index) {

        MyLinkedNode<E> node = head;
        for (int j = 0; j <= index; j++)
        {
            if (node.getNext().getValue()!=null) //POSSIBLY VERY BAD!
                node = node.getNext();
        }

        return node.getValue();
    }

    public MyLinkedNode<E> getNode(int index)
    {
        MyLinkedNode<E> node = head;
        for (int j = 0; j <= index; j++)
        {
            node = node.getNext();
        }
        return node;
    }


    /**
     * Adds a new element to the end of the list:
     *
     * @param elem
     */

    public void add(E elem) {

        MyLinkedNode<E> newNode = new MyLinkedNode(elem);

        newNode.setNext(tail);

        MyLinkedNode<E> secondToLast = tail.getPrev();

        secondToLast.setNext(newNode);

        tail.setPrev(newNode);

        newNode.setPrev(secondToLast);


        numElements++;

    }


    /**
     * Inserts a new element at the specified index.
     *
     * @param elem
     */

    public void add(int i, E elem) {

        MyLinkedNode<E> current = head;

        for (int j = 0; j <= i; j++)

        {

            current = current.getNext();

        }


        MyLinkedNode<E> prevNode = current.getPrev();

        MyLinkedNode<E> newNode = new MyLinkedNode(elem);


        newNode.setNext(current);

        newNode.setPrev(prevNode);

        prevNode.setNext(newNode);

        current.setPrev(newNode);


        numElements++;


    }


    /**
     * Returns the current size of the list.
     *
     * @return
     */

    public int size() {

        return numElements;

    }


    /**
     * Clears the contents of the list.
     */

    public void clear() {

// set head's next to the tail

        head.setNext(tail);

        head.setPrev(null);


// set tails prev to the head

        tail.setPrev(head);

        tail.setNext(null);

        numElements = 0;

    }


    /**
     * These methods are only used by the unit tests.
     * <p/>
     * They are intentionally not public.
     *
     * @return
     */

    MyLinkedNode getHead() {
        return head;
    }

    MyLinkedNode getTail() {
        return tail;
    }

}

