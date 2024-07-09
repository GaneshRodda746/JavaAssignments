package com.nisum.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubList {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<>(Arrays.asList(1,2,3,5,6,78,9,10));
//        includes 1st index and doesn't consider 4th index element
        List<Integer> integers = list.subList(1, 4);
        System.out.println(integers);
    }
}
