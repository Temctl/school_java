package utility;

import java.util.NoSuchElementException;

public class MyStack<E> {
    private Node top;
    private int size = 0;

    public void push(E item){
        Node n;
        if(top == null){
            n = new Node(item);
        }else{
            n = new Node(top, item);
        }
        top = n;
        size++;
    }

    public E pop(){
        if(size == 0){
            throw new NoSuchElementException("stack is empty");
        } 
        Node curr = top;
        if(top.prev != null){
            top = top.prev;
        }else{
            top = null;
        }
        size--;
        return (E)curr.curr;
    }

    public E peek(){
        if(size == 0){
            throw new NoSuchElementException("stack is empty");
        } 
        return (E)top.curr;
    }

    public int size(){
        return size;
    }

    public String toString(){
        Node n = top;
        String output = "[";
        ArrayList<E> outputList = new ArrayList<E>();
        for(int i = 0; i < size; i++){
            outputList.add((E)n.curr);
            n = n.prev;
        }
        for(int i = outputList.size() - 1; i >= 0; i--){
            if(i == 0){
                output += outputList.get(i) + "";
            }else{
                output += outputList.get(i) + " ";
            }
        }
        output += "]";
        return output;
        
    }

    public boolean isEmpty(){
        boolean output = false;
        if(size == 0){
            output = true;
        }
        return output;
    }

    private static class Node<E>{
        Node prev;
        E curr;

        public Node(E curr){
            this(null, curr);
        }

        public Node(Node prev, E curr){
            this.prev = prev;
            this.curr = curr;
        }

    }
}
