package com.array.problems;

import java.util.Arrays;

public class Problems {
    public static void main(String[] args) {
        int[] arr = {1,4,7,3,4,3,9,20,2};

//        System.out.println(findTheSecondLargestElement(arr,arr.length));

//        System.out.println(findTheSecondSmallestElement(arr,arr.length));

//        leftRotateArrayByOnePlace(arr,arr.length);

//        reverse(0,arr.length-1,arr);

//        leftRotateArrayByDPlace(arr,arr.length,3);

//        moveZerosToTheEnd(new int[]{1,2,0,5,0,0,0,43,2,5});

//        System.out.println(missingNumber(new int[]{1,2,3,5}));

        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

    }

    static int findTheSecondLargestElement(int arr[],int n){

        int firstMax = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for(int i=0 ; i<n ; i++){
            if(arr[i] > firstMax ){
                //swap
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax && arr[i] != firstMax) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    static int findTheSecondSmallestElement(int arr[],int n){

        int firstSmallest = Integer.MAX_VALUE, secondSmallest = Integer.MAX_VALUE;
        for(int i=0 ; i<n ; i++){
            if(arr[i] < firstSmallest ){
                //swap
                secondSmallest = firstSmallest;
                firstSmallest = arr[i];
            } else if (arr[i] < secondSmallest && arr[i] != firstSmallest) {
                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }

    static void leftRotateArrayByOnePlace(int[] arr,int n){
        int firstNum = arr[0];
        for(int i=0 ; i<n-1 ; i++){
            arr[i] = arr[i+1];
        }
        arr[n-1] = firstNum;
    }

    static void reverse(int start,int end,int[] arr){
        while(start<=end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void leftRotateArrayByDPlace(int[] arr,int n,int d){
        if(d>n) d = d % n ;

        reverse(0,d-1,arr);
        reverse(d,n-1,arr);
        reverse(0,n-1,arr);
    }

    static void moveZerosToTheEnd(int[] arr ) {

        int n = arr.length;
        int[] newArr = new int[n];
        int j = 0;
        for(int i=0 ; i<n ; i++){
            if(arr[i] != 0 ){
                newArr[j] = arr[i];
                j++;
            }
        }
        Arrays.stream(newArr).forEach(i -> System.out.print(i + " "));

    }

    static int missingNumber(int[] arr){
        int n = arr.length;
        int summation = (n * (n + 1)) / 2;
        int sum = 0;
        for(int i=0 ;i<n-1 ; i++){
           sum+=arr[i];
        }
        return summation - sum ;
    }



}
