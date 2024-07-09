package com.nisum.problemSolving;

import java.util.Arrays;

public class ReplaceAllZerosWithOnes {
    private static int[] replaceAllZerosWithOnes(int arr[]){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0)
                arr[i]=1;
        }
        return arr;
    }
// if array contains only 1's and 0's, use Arrays.fill(array,element)
    private static int[] efficientAlgo(int arr[]){
        Arrays.fill(arr,1);
        return arr;
    }
    public static void main(String[] args) {
        int arr[]={1,0,0,0,0,0,1,1,0,1,0};
        replaceAllZerosWithOnes(arr);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        int arr2[]={1,0,0,0,0,0,1,1,0,1,0};
        System.out.println();
        efficientAlgo(arr2);
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
