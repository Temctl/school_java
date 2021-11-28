package activities;

import java.util.Scanner;
import utility.MyStack;

public class UndoRedoProgram {

    public static void main(String[] args){
        MyStack<String> listOfInputs = new MyStack<String>();
        MyStack<String> listOfUndos = new MyStack<String>();

        Scanner scanner = new Scanner(System.in);

        boolean done = false;
        while (!done) {
            System.out.println("type in quite to quit the program");
            System.out.println("input any word or sentence(type in u for undo, r for redo):");
            String input = scanner.nextLine();
            if(input.equals("quit")){
                done = true;
            }else if(input.equals("r") || input.equals("R")){
                if(listOfUndos.size() == 0){
                    System.out.println("no inputs to undo");
                }else{
                    listOfInputs.push(listOfUndos.pop());
                    System.out.println(listOfInputs);
                }
            }else if(input.equals("u") || input.equals("U")){
                if(listOfInputs.size() == 0){
                    System.out.println("need input");
                }else{
                    listOfUndos.push(listOfInputs.pop());
                    System.out.println(listOfInputs);
                }
            }else{
                listOfInputs.push(input);
                System.out.println(listOfInputs);
            }
        }
        
    }

}
