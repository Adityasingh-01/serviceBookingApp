package com.service.demo;

public class MergeSortedArrays {

    public static void main(String args[]) {

        int[] inputArrayUnsorted = {23, 45, 65, 90, 101,24, 25, 34, 67, 89};

        int[] finalArray = sort(inputArrayUnsorted);

        for(int i = 0; i<finalArray.length; i++) {
            System.out.print(finalArray[i] + " ,");
        }
    }

    public static int[] sort(int[] inputArray) {
        int beg = 0;
        int end = inputArray.length - 1;
        int[] finalArray = new int[inputArray.length];
        if (beg<end) {
            int mid = (beg+end)/2;
            int leftArrayLength = mid - beg + 1;
            int rightArrayLength = end - mid;
            int leftArray[] = new int [leftArrayLength];
            int rightArray[] = new int [rightArrayLength];
            for (int i=0; i<leftArrayLength; ++i) {
                leftArray[i] = inputArray[beg + i];
            }
            for (int j=0; j<rightArrayLength; ++j) {
                rightArray[j] = inputArray[mid + 1+ j];
            }
            sort(leftArray);
            sort(rightArray);
            finalArray = mergeAndSort(leftArray, rightArray);
        }
        return finalArray;
    }




    private static int[] mergeAndSort(int[] leftArray, int[] rightArray) {
        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int finalArrayIndex = 0;
        int[] finalArray = new int[leftArray.length + rightArray.length];

        while(leftArrayIndex < leftArray.length && rightArrayIndex < rightArray.length){
            if(leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                finalArray[finalArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                finalArray[finalArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            finalArrayIndex++;
        }

        while(leftArrayIndex < leftArray.length) {
            finalArray[finalArrayIndex] = leftArray[leftArrayIndex];
            finalArrayIndex++;
            leftArrayIndex++;
        }

        while(rightArrayIndex < rightArray.length) {
            finalArray[finalArrayIndex] = rightArray[rightArrayIndex];
            finalArrayIndex++;
            rightArrayIndex++;
        }


        return finalArray;
    }
}
