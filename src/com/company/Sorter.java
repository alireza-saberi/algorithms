package com.company;

public class Sorter {
    private int[] intArray = {10, 4, 5, 7, 16, 30, -10}; // short form is allowed only at variable initialization


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
    //    this is in-place algorithm
    //     this is a stable algorithm
    public int[] sortBubble(){
        for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
//                System.out.println(i);
                if (intArray[i] > intArray[i+1]) {
                    swap(intArray, i, i+1);
                }
            }
        }
        return intArray;
    }

    // one of the least efficient algorithms
    // Order of it is quadratic but is not swap
    // this is in place algorithm
    // This is an unstable algorithm
    public int[] sortSelection(){
        for(int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            int maxIndex = 0;

            for (int i = 1; i <= lastUnsortedIndex; i++){
                if(intArray[i] > intArray[maxIndex]) {
                    maxIndex = i;
                }
            }
            swap(intArray, maxIndex, lastUnsortedIndex);
        }
        return intArray;
    }

    // another least efficient algorithm
    // order is quadratic
    // this is in place algorithm involves many shifts
    // this is unstable algorithm
    public int[] sortInsertion(){

        for (int firstUnsortedIndex =1 ; firstUnsortedIndex < intArray.length; firstUnsortedIndex++){
            int newElement = intArray[firstUnsortedIndex];

            int i;

            for(i = firstUnsortedIndex; i > 0 && intArray[i-1] > newElement; i--){
                intArray[i-1] = intArray[i];
            }

            intArray[i] = newElement;

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
