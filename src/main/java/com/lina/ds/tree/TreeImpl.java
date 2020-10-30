package com.lina.ds.tree;

public class TreeImpl<E> {

    class Node<E>{
        E data;
        Node<E> right, left;

        public Node(E obj){
            data = obj;
            right = left = null;
        }
    }

    private Node<E> root;
    private int currentSize;

    private void add(E obj, Node<E> node){
        if(((Comparable<E>) obj).compareTo(node.data) >= 0){
            //if obj > data, comparable returns >0
            //Move to right
            if(node.right == null){
                node.right = new Node<E>(obj);
                return;
            }
            add(obj, node.right);
        }
        if(node.left == null){
            node.left = new Node<E>(obj);
            return;
        }

        add(obj, node.left);
    }

    public void add(E obj){
        if(root == null){
            root = new Node<E>(obj);
        }else{
            add(obj, root);
        }
        currentSize++;
    }

    public boolean contains(E obj){
        return contains(obj, root);
    }

    private boolean contains(E obj, Node<E> node){
        if(node == null){
            return false;
        }

        if(((Comparable<E>) obj).compareTo(node.data) == 0){
            return true;
        }

        if(((Comparable<E>) obj).compareTo(node.data) > 0){
           return contains(obj, node.right);
        }

        return contains(obj, node.left);
    }
}
