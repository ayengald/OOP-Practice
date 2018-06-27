package com.company;

import java.util.*;
//  GrowList is a mutable list that only gets longer.
public class GrowList <E> {

    private Map<Integer,E> values;

    public GrowList() { values = new HashMap<Integer,E>();}

    // add to the end of the list
    public void add(E o) {
        values.put(size(), o);
    }

    // number of values in list
    public int size() { return values.size(); }

    // get ith value in list
    public E get(int i) {
        if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.get");
        return values.get(i);
    }

    // update ith value in list;  return previous value or null if none
    public E set(int i, E o) {
        if (! inRange(i)) throw new IndexOutOfBoundsException("GrowList.set");
        return values.put(i, o);
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

    public Iterator valuesIt(){
        return new GrowListGen(this);
    }

    //Private inner class that implements Iterator interface
    private class GrowListGen implements Iterator {

        private GrowList gl;
        private int curIndex = 0;

        GrowListGen(GrowList itgl){
            //Requires: itgl != null
            gl = itgl;
        }

        public boolean hasNext() {
            return curIndex < gl.size();
        }

        public E next() throws NoSuchElementException {
            for (int e = curIndex; e < gl.size(); e++) {
                curIndex++;
                return (E) gl.get(e);
            }
            throw new NoSuchElementException("GrowList.valuesIt");
        }

        public void remove() throws UnsupportedOperationException {
            throw new UnsupportedOperationException("GrowList.valuesIt");
        }
    }

    public static void main(String[] args) {
        GrowList<String> list = new GrowList<String>();

        list.add("cat");
        list.add("dog");
        list.add("mouse");
        list.set(1,"bat");

        Iterator g = list.valuesIt();

        while(g.hasNext()){
            System.out.println("Iterator String item: " + g.next());
        }

        GrowList<Integer> list2 = new GrowList<Integer>();

        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.set(1,4);

        Iterator g2 = list2.valuesIt();

        while(g2.hasNext()){
            System.out.println("Iterator Integer item: " + g2.next());
            if((int)g2.next() == 4){
                g2.remove();
            }
        }

    }
}
