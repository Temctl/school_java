package utility;

public class ArrayList<E> implements List<E> {
    private int size;
    private E[] data;
    public static final int DEFAULT_CAPACITY = 10;

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity){
        data = (E[])new Object[capacity];
        size = capacity;
    }

    @Override
    public boolean add(E item){
        int lastIndex = size() - 1;
        ensureCapacity(lastIndex + 1);
        data[lastIndex + 1] = item;
        return true;
    }

    @Override
    public void add(int index, E item){
        shiftRight(index);
        data[index] = item;
        
    }

    private void checkIndex(int index){
        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

    public void clear(){
        data = null;
        size = 0;
    }

    @Override
    public boolean contains(E item){
        boolean found = false;
        for(int i = 0; i < size(); i++){
            if(data[i].equals(item)){
                found = true;
            }
        }
        return found;
    }

    @SuppressWarnings("unchecked")
    public void ensureCapacity(int capacity){
        if(capacity >= data.length){
            E[] dataCurr = data;
            data = (E[])new Object[(data.length * 2)];
            for(int i = 0; i < dataCurr.length; i++){
                data[i] = dataCurr[i];
            }
        }
    }

    public E get(int index){
        checkIndex(index);
        return data[index];
    }

    @Override
    public int indexOf(E item){
        int index = -1;
        int i = 0;
        boolean found = false;
        while(i < size() && !found){
            if(data[i].equals(item)){
                found = true;
                index = i;
            }
            i++;
        }
        return index;
    }

    public boolean isEmpty(){
        boolean empty = true;
        for(int i = 0; i < data.length; i++){
            if(data[i] != null){
                empty = false;
            }
        }
        return empty;
    }
    
    @SuppressWarnings("unchecked")
    public Iterator<E> iterator(){
        ArrayIterator it = new ArrayIterator();
        return it;
    }

    public E remove(int index){
        checkIndex(index);
        E current = data[index];
        shiftLeft(index);
        return current;
    }

    public boolean remove(E item){
        boolean removed = false;
        int index = indexOf(item);
        if(index != -1){
            remove(index);
            removed = true;
        }
        return removed;
    }

    @Override
    public E set(int index, E item){
         checkIndex(index);
         E curr = data[index];
         data[index] = item;
         return curr;
    }

    private void shiftLeft(int index){
        for(int i = index; i < size(); i++){
            data[i] = data[i + 1];
            data[i + 1] = null;
        }
    }

    private void shiftRight(int index){
        ensureCapacity(size());
        for(int i = size() - 1; i >= index; i--){
            data[i + 1] = data[i];
            data[i] = null;
        }
    }

    public int size(){
        size = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] != null){
                size += 1;
            }
        }
        return size;
    }

    public String toString(){
        String output = "[";
        for(int i = 0; i < size(); i++){
            output += "" + data[i] + " ";
        }
        output += "]";
        return output;
    }

    private class ArrayIterator implements Iterator{

        protected int index = 0;

        public boolean hasNext(){
            boolean output = false;
            if(data[index] != null){
                output = true;
            }
            return output;
        }

        public E next(){
            int curr = index;
            index++;
            return data[curr];

        }

        public void remove(){
            ArrayList.this.remove(index);
        }
    }
}
