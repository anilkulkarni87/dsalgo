package com.lina.ds.linkedlist;

import com.lina.dsutil.ListI;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @param <E>
 */
public class LinkedList<E> implements ListI<E> {

    class Node<E>{
        E data;
        Node<E> next;
        public Node(E obj){
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public LinkedList(){
        head = tail = null;
        currentSize = 0;
    }

    /**
     *
     * @param obj
     */
    public void addFirst(E obj){
        Node<E> node = new Node<E>(obj);
        if(head == null){
            node.next = head;
            head = tail = node;
            currentSize++;
        } else{
            node.next = head;
            head = node;
            currentSize++;
        }

    }

    public void addLast(E obj){
        Node<E> node = new Node<E>(obj);
        if(head == null){
            head = tail = node;
            currentSize++;
            return;
        }
        Node<E> tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next=node;
        tail = node;
        currentSize++;
    }

    public E removeFirst(){
        if(head == null){
            return null;
        }
        E tmp = head.data;
        if (head.next == null){
            head = tail = null;
            currentSize--;
        }
        else {
            head = head.next;
            currentSize--;
        }
        return tmp;
    }

    public E removeLast(){
        if(head == null){
            return null;
        }
        E tmp = tail.data;
        if (head.next == null){
            head = tail = null;
            currentSize--;
            return tmp;
        }
        Node<E> current = head, previous = null;
        while(current != tail){
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        return current.data;
    }

    public E peekFirst() {
        if(head == null){
            return null;
        }
        return head.data;
    }

    public E peekLast() {
        if(tail == null){
            return null;
        }
        return tail.data;
    }

    public void makeEmpty() {

    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    public int size() {
        return 0;
    }

    public boolean contains(E obj) {
        Node<E> current = head;
        while(current != null){
            if(((Comparable<E>)current.data).compareTo(obj)== 0){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public E remove(E obj) {
        Node<E> current = head, previous=null;
        while(current != null){
            if(((Comparable<E>)current.data).compareTo(obj)== 0){
                if(current==head){
                    return removeFirst();
                }
                if(current == tail){
                    return removeLast();
                }
                currentSize--;
                previous.next= current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    public Iterator<E> iterator() {
        return new IteratorHelper();
    }


    class IteratorHelper implements Iterator<E> {
        Node<E> index;
        public IteratorHelper(){
            index=head;
        }
        public boolean hasNext() {
            return (index!=null);
        }

        public E next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            E val = index.data;
            index = index.next;
            return val;
        }
    }
}
