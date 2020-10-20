package com.lina.ds.linkedlist;

public class DoublyLinkedListImpl<E> {

    class Node<E>{
        E data;
        Node<E> next;
        Node<E> previous;

        public Node(E obj){
            this.data = obj;
            this.next = this.previous = null;
        }
    }

    private Node<E> head, tail;
    private int size;


    /*
     * Implement below methods:
     * addFirst - Add a node at the beginning
     * addLast - Add a node at the end
     * removeFirst - Remove node at beginning
     * removeLast - Remove node at the end
     * peekFirt - Return first node
     * peekLast - Return last node
     * contains - Return true if data exists
     * remove - Remove node if data exists
     * size - Return current size of LinkedList
     * */

    public void addFirst(E obj){
        Node<E> newNode = new Node(obj);
        if(head == null){
            head = tail = newNode;
            size++;
        }else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
            size++;
        }
    }

    public void addLast(E obj){
        Node<E> newNode = new Node(obj);
        if(head == null){
            head = tail = newNode;
            size++;
            return;
        }
        Node<E> current = head;
        while(current != tail){
            current = current.next;
        }
        tail.next = newNode;
        newNode.previous = tail;
        tail = newNode;
        size++;
    }
}
