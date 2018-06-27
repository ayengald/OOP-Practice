package com.company;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //Sample cases
        List<Integer> a =  new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();

        a.add(8);
        a.add(7);
        a.add(23);
        a.add(7);
        a.add(7);
        a.add(12);
        a.add(14);
        a.add(12);

        b.add(7);
        b.add(3);
        b.add(5);
        b.add(2);
        b.add(4);
        b.add(4);
        b.add(2);

        System.out.println(com.company.FindPrimeFactor.findPrimeFactor(a, b));

    }
}
