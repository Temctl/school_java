package utility;

public class Test {

    public static void main(String[] args){
        MyQueue<String> queue = new MyQueue<String>();
        System.out.println("queue before: " + queue);
        queue.add("red");
        queue.add("orange");
        queue.add("yellow");
        queue.add("green");
        queue.add("blue");
        queue.add("indigo");
        queue.add("violet");
        System.out.println("queue after: " + queue);

        MyStack<String> stack = new MyStack<String>();
        System.out.println("queue before: " + stack);
        stack.push("red");
        stack.push("orange");
        stack.push("yellow");
        stack.push("green");
        stack.push("blue");
        stack.push("indigo");
        stack.push("violet");
        System.out.println("queue after: " + stack);

        MyQueue<Integer> queueInt = new MyQueue<Integer>();
        queueInt.add(3);
        queueInt.add(4);
        queueInt.add(5);
        queueInt.add(17);
        queueInt.add(6);
        queueInt.add(1);
        queueInt.add(8);
        queueInt.add(12);
        queueInt.add(9);
        queueInt.add(16);
        System.out.println("queueInt before rearange: " + queueInt);
        System.out.println("queueInt after rearange: " + rearrange(queueInt));

        MyStack<Integer> stackInt = new MyStack<Integer>();
        stackInt.push(13);
        stackInt.push(9);
        stackInt.push(6);
        stackInt.push(5);
        stackInt.push(4);
        stackInt.push(2);
        stackInt.push(1);
        System.out.println("stackInt before switchPairs: " + stackInt);
        System.out.println("stackInt after switchPairs: " + switchPairs(stackInt));

        System.out.println("the stack " + stackInt + " is sorted: " + isSorted(stackInt));
        MyStack<Integer> stackInt2 = new MyStack<Integer>();
        stackInt2.push(1);
        stackInt2.push(3);
        stackInt2.push(8);
        stackInt2.push(10);
        stackInt2.push(11);
        stackInt2.push(15);
        stackInt2.push(65);
        System.out.println("the stack " + stackInt2 + " is sorted: " + isSorted(stackInt));
    }
    
    public static MyQueue<Integer> rearrange(MyQueue<Integer> queue){
        MyQueue<Integer> oddList = new MyQueue<Integer>();
        int size = queue.size();
        for(int i = 0; i < size; i++){
            int curr = queue.remove();
            if(curr % 2 == 0){
                queue.add(curr);
            }else{
                oddList.add(curr);
            }
        }
        int oddSize = oddList.size();
        for(int i = 0; i < oddSize; i++){
            queue.add(oddList.remove());
        }
        return queue;
    }

    public static MyStack<Integer> switchPairs(MyStack<Integer> stack){
        int size = stack.size();
        MyStack<Integer> stackHolder = new MyStack<Integer>();
        for(int i = 0; i < (size / 2); i++){
            MyStack<Integer> pairHolder = new MyStack<>();
            pairHolder.push(stack.pop());
            pairHolder.push(stack.pop());
            stackHolder.push(pairHolder.pop());
            stackHolder.push(pairHolder.pop());
        }
        int stackHolderSize = stackHolder.size();
        for(int i = 0; i < stackHolderSize; i++){
            stack.push(stackHolder.pop());
        }
        return stack;
    }

    public static boolean isSorted(MyStack<Integer> stack){
        boolean output = true;
        int size = stack.size();
        for(int i = 0; i < (size -1); i++){
            if(stack.pop() < stack.peek()){
                output = false;
            }
        }
        return output;
    }


}
