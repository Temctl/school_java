package utility;

import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>{

    private Node first;
    private Node last;
    private int size;

    @SuppressWarnings("unchecked")
    public LinkedList(){
        size = 0;
        first = null;
    }

    public boolean add(E item){
        append(item);
        return true;
    }

    public void add(int index, E item){
        if(index == size){
            append(item);
        }else{
            insertBefore(index, item);
        }
        
    }

    private void append(E item){
        if(first == null){
            first = new Node(null, null, item);
            last = first;
            size++;
        }else{
            Node n = first;
            for(int i = 0; i < size - 1; i++){
                n = n.next;
            }
            n.next = new Node(n, null, item);
            last = n.next;
            size++;
        }
    }

    private void checkIndex(int index){
        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

    public boolean contains(E item){
        boolean output = false;
        if(indexOf(item) != -1){
            output = true;
        }
        return output;
    }

    public void clear(){
        first = new Node(null, null, null);
        last = new Node(null, null, null);
        size = 0;
    }

    private E detach(int index){
        checkIndex(index);
        Node n = node(index);
        if(index == size - 1){
            last = n.prev;
            last.next = null;
        }else{
            if(index == 0){
                if(n.next.equals(null)){
                    clear();
                }else{
                    first = n.next;
                    first.prev = null;
                }
            }else{
                Node prev = n.prev;
                Node next = n.next;
                prev.next = next;
                next.prev = prev;
            }
        }
        size--;
        return (E)n.curr;
    }

    public E get(int index){
        return (E)node(index).curr;
    }

    public int indexOf(E item){
        Node n = first;
        int index = -1;
        int i = 0;
        while(n != null && index == -1){
            if(n.curr.equals(item)){
                index = i;
            }
            n = n.next;
            i++;
        }
        return index;
    }

    private void insertBefore(int index, E item){
        if(index == size){
            Node newNode = new Node(last, null, item);
            last = newNode;
        }else{
            Node n = node(index);
            if(index != 0){
                Node newNode = new Node(n.prev, n, item);
                Node prev = n.prev;
                n.prev = newNode;
                prev.next = newNode;
            }else{
                Node newNode = new Node(null, n, item);
                first = newNode;
            }
            
        }
        size++;
    }

    public boolean isEmpty(){
        boolean output = false;
        if(first.curr.equals(null)){
            output = true;
        }
        return output;
    }

    public Iterator iterator(){
        LinkedIterator it = new LinkedIterator();
        return it;
    }

    private Node node(int index){
        checkIndex(index);
        Node n = first;
        for(int i = 0; i < index; i++){
            n = n.next;
        }
        return n;
    }

    public E remove(int index){
        checkIndex(index);
        Node n = node(index);
        detach(index);
        return (E)n.curr;
    }

    public boolean remove(E item){
        boolean output = true;
        int index = indexOf(item);
        if(index != -1){
            remove(index);
        }else{
            output = false;
        }
        return output;
    }

    public E set(int index, E item){
        checkIndex(index);
        Node n = node(index);
        E curr = (E)n.curr;
        n.curr = item;
        return curr;
    }

    public int size(){
        return size;
    }

    public String toString(){
        Iterator it = iterator();
        String output = "[";
        while(it.hasNext()){
            output += (it.next() + " ");
        }
        output += "]";
        return output;
    }


    private static class Node<E>{
        E curr;
        Node prev;
        Node next;

        public Node(Node prev, E data){
            this(prev, null, data);
        }

        public Node(Node prev, Node next, E data){
            curr = data;
            this.prev = prev;
            this.next = next;
        }

    }

    private class LinkedIterator implements Iterator{

        Node n = first;
        boolean usedNext = false;

        public boolean hasNext(){
            boolean output = false;
            if(n != null){
                output = true;
            }
            return output;
        }

        public E next(){
            if(n.curr.equals(last)){
                throw new NoSuchElementException("no more element left!");
            }
            E curr = (E)n.curr;
            n = n.next;
            usedNext = true;
            return curr;
            

        }

        public void remove(){
            if(usedNext){
                LinkedList.this.remove((E)n.curr);
            }else{
                throw new IllegalStateException("must use next() before this!");
            }
        }
    }


}
