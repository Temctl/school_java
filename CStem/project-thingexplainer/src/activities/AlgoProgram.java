package activities;

import java.util.PrimitiveIterator.OfDouble;

import utility.ArrayList;

import utility.ArrayList;
import utility.Module;

public class AlgoProgram {

    static ArrayList<String> firstNames = new ArrayList<String>();
    static ArrayList<String> lastNames = new ArrayList<String>();
    static ArrayList<Integer> ages = new ArrayList<Integer>();

    public static void main(String[] args){
        Module module;
        firstNames.add("bob");
        firstNames.add("james");
        firstNames.add("nathaniel");

        lastNames.add("bagel");
        lastNames.add("crate");
        lastNames.add("adam");

        ages.add(17);
        ages.add(64);
        ages.add(2);

        module = new Module<String>();
        System.out.println("people before any sorting");
        for(int i = 0; i < ages.size(); i++){
            System.out.println("name: " + firstNames.get(i) + " " + lastNames.get(i) + " age: " + ages.get(i));
        }
        System.out.println("after sorting it by first name:");
        firstNames = module.sort(firstNames);
        int indexOfBob = firstNames.indexOf("bob");
        lastNames.set(indexOfBob, "bagel");
        ages.set(indexOfBob, 17);

        int indexOfJames = firstNames.indexOf("james");
        lastNames.set(indexOfJames, "crate");
        ages.set(indexOfJames, 64);

        int indexOfNathaniel = firstNames.indexOf("nathaniel");
        lastNames.set(indexOfNathaniel, "adam");
        ages.set(indexOfNathaniel, 2);
        for(int i = 0; i < ages.size(); i++){
            System.out.println("name: " + firstNames.get(i) + " " + lastNames.get(i) + " age: " + ages.get(i));
        }


        module = new Module<Integer>();
        System.out.println("people before age sort");
        for(int i = 0; i < ages.size(); i++){
            System.out.println("name: " + firstNames.get(i) + " " + lastNames.get(i) + " age: " + ages.get(i));
        }
        System.out.println("after sorting it by ages:");
        ages = module.sort(ages);
        indexOfBob = ages.indexOf(17);
        lastNames.set(indexOfBob, "bagel");
        firstNames.set(indexOfBob, "bob");

        indexOfJames = ages.indexOf(64);
        lastNames.set(indexOfJames, "crate");
        firstNames.set(indexOfJames, "james");

        indexOfNathaniel = ages.indexOf(2);
        lastNames.set(indexOfNathaniel, "adam");
        firstNames.set(indexOfNathaniel, "nathaniel");
        for(int i = 0; i < ages.size(); i++){
            System.out.println("name: " + firstNames.get(i) + " " + lastNames.get(i) + " age: " + ages.get(i));
        }

        
        module = new Module<String>();
        System.out.println("people before last name sort");
        for(int i = 0; i < ages.size(); i++){
            System.out.println("name: " + firstNames.get(i) + " " + lastNames.get(i) + " age: " + ages.get(i));
        }
        System.out.println("after sorting it by last name:");
        lastNames = module.sort(lastNames);
        indexOfBob = lastNames.indexOf("bagel");
        firstNames.set(indexOfBob, "bob");
        ages.set(indexOfBob, 17);

        indexOfJames = lastNames.indexOf("crate");
        firstNames.set(indexOfJames, "james");
        ages.set(indexOfJames, 64);

        indexOfNathaniel = lastNames.indexOf("adam");
        firstNames.set(indexOfNathaniel, "nathaniel");
        ages.set(indexOfNathaniel, 2);
        for(int i = 0; i < ages.size(); i++){
            System.out.println("name: " + firstNames.get(i) + " " + lastNames.get(i) + " age: " + ages.get(i));
        }

    }



}
