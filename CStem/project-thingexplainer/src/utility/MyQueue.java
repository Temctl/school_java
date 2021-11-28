package utility;

import java.util.NoSuchElementException;

public class MyQueue<E> {

    private Node front = null;
    private int size = 0;

    public void add(E item){
        Node n = new Node(item);
        if(size == 0){
            front = n;
        }else{
            Node back = getBack();
            back.next = n;
        }
        size++;
    }

    public E remove(){
        
        if(size == 0){
            throw new NoSuchElementException("no element");
        }
        Node curr = front;
        if(size == 1){
            front = null;
        }else{
            front = curr.next;
        }
        size--;
        return (E)curr.curr;
    }

    public E peek(){
        E output;
        if(front == null){
            output = null;
        } else{
            output = (E)front.curr;
        }
        return output;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        boolean output = false;
        if(size == 0){
            output = true;
        }
        return output;
    }

    private Node getBack(){
        Node n = front;
        for(int i = 1; i < size; i++){
            n = n.next;
        }
        return n;
    }

    public String toString(){
        String output = "[";
        Node n = front;
        for(int i = 0; i < size; i++){
            output += n.curr + " ";
            n = n.next;
        }
        output += "]";
        return output;
    }

    private class Node<E>{
        E curr;
        Node next;

        public Node(E curr){
            this.curr = curr;
        }
    }



}
