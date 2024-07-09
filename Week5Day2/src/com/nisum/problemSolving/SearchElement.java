package com.nisum.problemSolving;

import java.util.Arrays;

public class SearchElement {

//    linear search
    private static int searchElement(int arr[],int element){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                return i;
            }
        }
        return -1;
    }

//    using binary search
    private static int searchElementUsingBinarySearch(int arr[],int element){
        Arrays.sort(arr);
        int i=0;
        int j= arr.length-1;

        while(i<j){
            int mid=i+(j-i)/2;
            if(arr[mid]==element)
                return mid;
            else{
                if(arr[mid]<element){
                    i = mid + 1;
                }
                else{
                    j=mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int i = searchElementUsingBinarySearch(arr, 3);
        System.out.println(i);
        int element =searchElement(arr,5);
        System.out.println(element);
    }
}
