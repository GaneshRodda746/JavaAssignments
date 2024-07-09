package com.nisum.problemSolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveElement {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
        System.out.println(list);
        list.remove(3);
        System.out.println(list);

    }
}
