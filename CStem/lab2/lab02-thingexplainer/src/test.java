import java. util. *; 
public class test {

    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(7);
        stack.push(1);
        stack.push(14);
        stack.push(9);
        System.out.println(stutter(stack));

    }
    public static Stack<Integer> stutter(Stack<Integer> stack){
        ArrayList<Integer> array = new ArrayList<>(); 
        for(int i = 0; i < stack.size(); i++){
            int curr = stack.pop();
            array.add(curr);
            array.add(curr);
        }
        for(int i = array.size() - 1; i >= 0; i--){
            stack.add(array.get(i));
        }
        return stack;
    }
}
