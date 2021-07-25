package com.service.demo;

public class MergeSortExample {

    public static void main(String args[]) {
        int arr[] = {90,23,101,45,65,24,67,89,34,25};
        sort(arr, 0, arr.length-1);
        for(int i =0; i<arr.length;i++) {
            System.out.println(arr[i]+"");
        }
    }


    public static void sort(int[] arr, int beg, int end) {
        if(beg < end) {
            int mid = (beg + end)/2;
            sort(arr, beg, mid);
            sort(arr, mid+1, end);

            int leftArrayLength = mid - beg + 1;
            int rightArrayLength = end - mid;

            int leftArray[] = new int [leftArrayLength];
            int rightArray[] = new int [rightArrayLength];

            for (int i=0; i<leftArrayLength; ++i) {
                leftArray[i] = arr[beg + i];
            }

            for (int j=0; j<rightArrayLength; ++j) {
                rightArray[j] = arr[mid + 1+ j];
            }

            merge(leftArray, rightArray, arr, beg);
        }
    }


    public static void merge(int[] leftArray, int[] rightArray, int[] finalArray, int beg) {
        int leftArrayLength = leftArray.length;
        int rightArrayLength = rightArray.length;

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int finalArrayIndex = beg;

        while (leftArrayIndex<leftArrayLength && rightArrayIndex<rightArrayLength) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                finalArray[finalArrayIndex] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            }
            else {
                finalArray[finalArrayIndex] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            finalArrayIndex++;
        }

        while (leftArrayIndex<leftArrayLength)
        {
            finalArray[finalArrayIndex] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            finalArrayIndex++;
        }

        while (rightArrayIndex<rightArrayLength)
        {
            finalArray[finalArrayIndex] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            finalArrayIndex++;
        }
    }



}
