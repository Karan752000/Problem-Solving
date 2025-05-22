package com.array.sarching;

import java.util.Arrays;

public class Searching {
    public static void main(String[] args) {

        int[] arr = {1,4,7,3,4,3,9,20,2};
        int k = 9;

        int indexPos = linearSearch(arr,k);
        System.out.println("index postion at : "+indexPos);

        Arrays.sort(arr);
        indexPos = binarySearch(arr, k);
        System.out.println("index postion at : "+indexPos);
    }

    private static int binarySearch(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int j = n-1;

        while(i <= j){
            int mid = (i + j) / 2;
            if(arr[mid] == k) return mid;

            if(arr[mid] > k){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        return -1;
    }

    private static int linearSearch(int[] arr, int k) {
        int n = arr.length;
        for(int i=0 ; i<n ; i++) {
            if (arr[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
