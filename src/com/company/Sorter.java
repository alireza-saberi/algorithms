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

    // Merge sort:  quiet efficient algorithm
    // recursive and order is n log n
    // this is NOT in place algorithm
    // this is a stable algorithm
    /*
        the idea is like
        mergesort(array) {
            mergesort(array's left half)
            mergesort(array's right side)
            merge left & right half in sorted order
        }
        taken from Tutorial with Gayle Laakmann McDowell on youtube (https://www.youtube.com/watch?v=KF2j-9iSf4Q)
     */
    public static  void mergeSort(int[] array){
        mergeSort(array, new int[array.length -1], 0, array.length -1);
    }

//    our recurs
    public static void mergeSort(int[] array, int[] temp, int leftStart, int rightEnd){
        if (leftStart >= rightEnd){
            return;
        }
        int middle = (leftStart + rightEnd) / 2;
        mergeSort(array, temp, leftStart, middle);
        mergeSort(array, temp,middle + 1, rightEnd);
        mergeHalves(array, temp,leftStart, rightEnd);
    }

    public static void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd ){
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = leftEnd - rightStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while( left <= leftEnd && right <= rightEnd){
            if( array[left] <= array[right]){
                temp[index] = array[left];
                left++;
            } else{
                temp[index] = array[right];
                right++;
            }
            index++;
            System.arraycopy(array, left, temp, index, leftEnd - left + 1);
            System.arraycopy(array, right,temp, index, rightEnd - right +1);
            System.arraycopy(temp, leftStart, array, leftStart, size);
        }
    }

    // Quick sort:  quiet efficient algorithm
    // recursive and order is n log n
    // this is NOT in place algorithm
    // this is a stable algorithm
    /*
        taken from Tutorial with Gayle Laakmann McDowell on youtube (    // Merge sort:  quiet efficient algorithm
    // recursive and order is n log n
    // this is NOT in place algorithm
    // this is a stable algorithm
    /*
        the idea is like
        mergesort(array) {
            mergesort(array's left half)
            mergesort(array's right side)
            merge left & right half in sorted order
        }
        taken from Tutorial with Gayle Laakmann McDowell on youtube (https://www.youtube.com/watch?v=KF2j-9iSf4Q)
     */
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length);
    }

    public static void  quickSort(int[] array, int left, int right){
        if (left > right) {
            return;
        }

        int pivot = array[(left + right)/2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index -1);
        quickSort(array, index, right);
    }

    public static int partition(int[] array, int left, int right, int pivot){
        while (left <= right) {
            while ( array[left] < pivot) {
                left++;
            }
            while (array[right] > pivot) {
                right--;
            }
            if(left <= right){
                swap(array,left, right );
                left++;
                right--;
            }
        }

        return  left;
    }
}
