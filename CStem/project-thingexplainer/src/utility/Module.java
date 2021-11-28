package utility;

public class Module<E extends Comparable<E>> {

    ArrayList<E> array = new ArrayList<E>();

    public LinkedList sort(LinkedList list){
        for(int i = 0; i < list.size(); i++){
            array.add((E)list.get(i));
        }
        array = quickSort(array, 0, array.size() - 1);
        list.clear();
        for(int i = 0; i < array.size(); i++){
            list.add((E)array.get(i));
        }
        return list;
    }

    public ArrayList sort(ArrayList list){
        return(quickSort(list, 0, list.size() - 1));
    }

    public MyQueue sort(MyQueue list){
        for(int i = 0; i < list.size(); i++){
            array.add((E)list.remove());
        }
        array = quickSort(array, 0, array.size() - 1);
        for(int i = 0; i < array.size(); i++){
            list.add((E)array.get(i));
        }
        return list;
    }

    public MyStack sort(MyStack list){
        for(int i = 0; i < list.size(); i++){
            array.add((E)list.pop());
        }
        for(int i = 0; i < array.size(); i++){
            array.add(array.remove(array.size() - 1));
        }
        array = quickSort(array, 0, array.size() - 1);
        for(int i = 0; i < array.size(); i++){
            list.push((E)array.get(i));
        }
        return list;
    }

    private ArrayList quickSort(ArrayList list, int left, int right){
        if(left < right){
            int partIndex = partition(list, left, right);

            quickSort(list, left, partIndex-1);
            quickSort(list, partIndex + 1, right);
        }
        return list;
    }

    private int partition(ArrayList list, int left, int right){
        E pivot = (E)list.get(right);
        int i = (left - 1);

        for (int j = left; j < right; j++) {
            if (((E)list.get(j)).compareTo(pivot) <= 0) {
                i++;

                E holder = (E)list.get(i);
                list.set(i, (E)list.get(j));
                list.set(j, holder);
            }
        }

        E holder = (E)list.get(i + 1);
        list.set(i + 1, (E)list.get(right));
        list.set(right, holder);

        return (i + 1);
    }

    
}
 
