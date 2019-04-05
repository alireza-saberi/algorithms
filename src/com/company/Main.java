package com.company;


public class Main {

    public static void main(String[] args) {
        // testing bubble sorter
        Sorter st = new Sorter();
        int[] intArray = st.sortBubble();

        System.out.println("Result of bubble sort");
        System.out.println("=====================");
        for (int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }


        // testing selection sorter
        Sorter st2 = new Sorter();
        int[] intArray2 = st2.sortSelection();

        System.out.println("Result of selection sort");
        System.out.println("=====================");
        for (int i = 0; i < intArray2.length; i++){
            System.out.println(intArray2[i]);
        }

        // testing insertion sorter
        Sorter st3 = new Sorter();
        int[] intArray3 = st3.sortSelection();

        System.out.println("Result of insertion sort");
        System.out.println("=====================");
        for (int i = 0; i < intArray3.length; i++){
            System.out.println(intArray3[i]);
        }

    }
}
