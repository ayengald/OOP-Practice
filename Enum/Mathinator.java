package com.assignment12;

import java.util.List;
import java.util.Iterator;

public class Mathinator {

    //variables

    //constructors
    public Mathinator() {
    }

    //methods
    public int addInts(Integer a, Integer b) {
        if (a == null || b == null) throw new NullPointerException("Mathinator.subInts");
        return a + b;
    }

    public int subInts(Integer a, Integer b) {
        if (a == null || b == null) throw new NullPointerException("Mathinator.subInts");
        return a - b;
    }

    public int getMax(List<Integer> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException("Mathinator.max");
        }
        Iterator<Integer> itr = list.iterator();
        Integer result = itr.next();

        if (result == null) throw new NullPointerException("Mathinator.max");

        while (itr.hasNext()) {   // throws NPE, CCE as needed
            Integer comp = itr.next();
            if (comp.compareTo(result) > 0) {
                result = comp;
            }
        }
        return result;

    }


}
