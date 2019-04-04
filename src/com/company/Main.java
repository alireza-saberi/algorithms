package com.company;


public class Main {

    public static void main(String[] args) {
        Sorter st = new Sorter();
        int[] intArray = st.sortBubble();

        for (int i = 0; i < intArray.length; i++){
            System.out.println(intArray[i]);
        }




    }
}
