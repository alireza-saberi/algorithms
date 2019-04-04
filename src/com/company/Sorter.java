package com.company;

public class Sorter {
    private int[] intArray = {20, 19, 18, 17, 16, 15,14}; // short form is allowed only at variable initialization


    public Sorter() {
    }

    public Sorter(int[] intArray) {
        this.intArray = intArray;
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    //    one of the  least efficient algorithms
    //    order of it is quadratic
    //    this is in-place algirithm
    //     this is a stable algorithm
    public int[] sortBubble(){
        for(int lastUnsortedIndex = intArray.length; lastUnsortedIndex > 0; lastUnsortedIndex--)
            for (int i = 0; i > lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i++]) {
                    swap(intArray, i, i++);
                }
            }
        return intArray;
    }
    

    public static void swap(int[] array, int i, int j){
        if ( i == j ) return;

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}
