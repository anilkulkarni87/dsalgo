package com.lina.ds.linkedlist;

public class LinkeListImpl<E> {

    class Node<E>{
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
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
     //If linkedlist is empty
     Node<E> newNode  = new Node<E>(obj);
     if(head == null){
         head = tail = newNode;
         size++;
     } else{ // If LinkedList is not empty
         newNode.next  = head;
         head = newNode;
         size++;
     }
 }

 public void addLast(E obj){
     Node<E> newNode  = new Node<E>(obj);
     if(head == null){
         head = tail = newNode;
         size++;
     }else{
         tail.next = newNode;
         tail = newNode;
         size++;
     }
 }

 public E removeFirst(){
     if(head == null){
         return  null;
     }
     E tmp = head.data;
     if(head.next == null){
         head = tail = null;
         size--;
     }
     else{
         head = head.next;
         size--;
     }

     return tmp;
 }

 public E removeLast(){
     if(head == null){
         return null;
     }
     E tmp = tail.data;
     if(head.next == null){
         head = tail = null;
         size--;
         return tmp;
     }

     Node<E> current=head, previous = null;
     while(current != tail){
         previous = current;
         current = current.next;
     }
     previous.next = null;
     tail = previous;
     size--;
     return  tmp;
 }

 public E peekFirst(){
     if(head == null){
         return null;
     }
     return head.data;
 }

 public E peekLast(){
     if(head == null){
         return null;
     }
     return tail.data;
 }

 public boolean contains(E obj){
     Node<E> current = head;
     while(current != null){
         if(((Comparable<E>) current.data).compareTo(obj) == 0){
             return true;
         }
         current = current.next;
     }
     return false;
 }

 public E remove(E obj){
     Node<E> current = head, previous = null;
     while(current != null){
         if(((Comparable<E>) current.data).compareTo(obj) == 0){
             if(current == head){
                 return removeFirst();
             }

             if(current == tail){
                 return removeLast();
             }

             size--;
             previous.next=current.next;
             return current.data;
         }
         previous = current;
         current = current.next;
     }

     return null;
 }

    public int getSize() {
        return size;
    }
}
