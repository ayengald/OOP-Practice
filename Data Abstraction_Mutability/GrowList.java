package com.company;

import java.util.*;

public class GrowList <E> {
// OVERVIEW:  GrowList is a immutable list that only gets longer.

    private Map<Integer,E> values;

    //constructors
    public GrowList() { values = new HashMap<Integer,E>();}

    private GrowList(Map<Integer,E> oldValues){
        values = new HashMap<Integer,E>();
        if(oldValues.size() > 0){
            for(int i = 0; i < oldValues.size(); i++){
                values.put(i, oldValues.get(i));
            }
        }
    }

    // Return a new GrowList with addition to the end of the list
    public GrowList add(GrowList g, E o) {
        GrowList k = new GrowList(g.values);

        int i = g.size();
        k.values.put(i, o);

        return k;
    }

    // number of values in list
    public int size() {
        return values.size();
    }

    // get ith value in list
    public E get(int i) {
        //if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
        return values.get(i);
    }

    // Return a new GrowList with the updated ith value in list if exists;
    public GrowList set(GrowList g, int index, E o) {
        GrowList k = new GrowList(g.values);

        k.values.put(index, o);

        return k;
    }

    // private helper method
    private boolean inRange(int i) { return (i >= 0) && (i < size()); }

    public String toString() {
        if (size() == 0) return "[]";
        String result = "[";
        for (int i = 0; i < size()-1; i++) {
            result += values.get(i) + ",";
        }
        return result + values.get(size() - 1) + "]";
    }

    public static void main(String[] args) {

        GrowList<String> l1 = new GrowList<String>();

        l1 = l1.add(l1, "abhishek");
        l1 = l1.add(l1, "test");
        l1 = l1.add(l1, "yashu");
        l1 = l1.set(l1, 1, "bhanu");

        System.out.println("list is:" + l1);

    }
}
