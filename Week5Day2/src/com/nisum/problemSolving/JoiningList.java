package com.nisum.problemSolving;

import java.util.ArrayList;
import java.util.List;

public class JoiningList {
    public static void main(String[] args) {
        List<Integer> list1=new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2=new ArrayList<>();
        list1.add(4);
        list1.add(5);
        list1.add(6);

        list1.addAll(list2);
        System.out.println(list1);

    }
}
