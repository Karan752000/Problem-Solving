package com.array.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Sorting {
    public static void main(String[] args) {

        int[] arr = {1,4,7,3,4,3,9,20,2};

//        selectionSort(arr);

//        bubbleSort(arr);

//        insersionSort(arr);

//        mergeSort(arr,0, arr.length-1);

//        quickSort(arr,0,arr.length-1);

        Arrays.stream(arr).forEach(i -> System.out.print(i + " "));

    }

    public static void quickSort(int[] arr , int low , int high){
        if(low < high){
            int partitonIdx = qs(arr,low,high);
            quickSort(arr,low , partitonIdx-1);
            quickSort(arr,partitonIdx+1 , high);

        }
    }

    public static int qs(int[] arr , int low , int high){
        int i = low;
        int j = high;
        int pivot = arr[low];

        while(i < j){

            while(arr[i] <= pivot && i < high){
                i++;
            }

            while( arr[j] > pivot && j > low){
                j--;
            }
            //swap
            if(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        //swap
        int temp = arr[j];
        arr[j] = pivot;
        arr[low] = temp;
        return j;
    }

    private static void mergeSort(int[] arr , int start , int end){
        if(start == end) return;

        int mid = (start+end)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid+1,end);
        merge(arr,start,mid,end);
    }

    private static void merge(int[] arr , int start ,int mid , int end){
        List<Integer> list = new ArrayList<>();

        int i = start;
        int j = mid+1;

        // 1,3,5   -  2,3,6
        while( i <=  mid  && j <= end){
            if(arr[i] <= arr[j]){
                list.add(arr[i]);
                i++;
            }else{
                list.add(arr[j]);
                j++;
            }
        }

        while(i <= mid){
            list.add(arr[i++]);
        }

        while(j <= end){
            list.add(arr[j++]);
        }

        int idx = 0;
        for(int x=start ; x<=end ; x++){
            arr[x] = list.get(idx);
            idx++;
        }
    }


    private static void insersionSort(int[] arr) {
        int n = arr.length;
        for(int i=0 ; i<n ;i++){
            int j = i;
            while( j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1] ;
                arr[j-1] = temp;
                j--;
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for(int i=0 ; i<n-1 ; i++){
            boolean flagSwap = false;

            for(int j=0 ; j<n-1-i ; j++){
                if(arr[j] > arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flagSwap = true;
                }
            }

            if(!flagSwap) break;
        }
    }

    private static void selectionSort(int[] arr) {
        int n = arr.length;
        for(int i=0 ; i<n ; i++){
            int mini = i;
            for(int j=i+1 ; j<n ;j++){
                if( arr[j] < arr[mini] ){
                    mini = j;
                }
            }
            //swap
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i]  = temp;
        }
    }
}
