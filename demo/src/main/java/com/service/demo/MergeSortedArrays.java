package com.service.demo;

public class MergeSortedArrays {

    public static void main(String args[]) {

        int[] inputArrayUnsorted = {23, 101, 65, 33, 106,23, 23, 10001, 67, 89};
        int[] finalArray = new int[inputArrayUnsorted.length];
        finalArray = sort(inputArrayUnsorted, finalArray);

        for(int i = 0; i<finalArray.length; i++) {
            System.out.print(finalArray[i] + " ,");
        }
    }

    public static int[] sort(int[] inputArray, int[] finalArray) {
        int beg = 0;
        int end = inputArray.length - 1;

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
            leftArray = sort(leftArray, finalArray);
            rightArray = sort(rightArray, finalArray);
            finalArray = mergeAndSort(leftArray, rightArray);
        } else {
            finalArray = inputArray;
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
