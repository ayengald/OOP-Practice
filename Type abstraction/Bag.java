package com.company;

import java.util.*;

public class Bag<E> {
    // rep: map each object to the count of that object in this
    // rep-inv:  range of map contains only positive integers
    // Example:  A bag of 2 cats and a dog is map = { cat=2, dog=1 }

    private Map<E, Integer> map;

    public Bag() {
        map = new HashMap<E, Integer>();
    }

    // add 1 occurrence of e to this
    public void insert(E e) {
        if (isIn(e)) {
            map.put(e, map.get(e) + 1);
        } else {
            map.put(e, 1);
        }
    }

    // remove 1 occurrence of e from this
    public void remove(E e) {
        if(map.get(e) <= 1) {
            map.remove(e);
        } else {
            int count = map.get(e);
            map.put(e, --count);
        }
    }

    // return true if e is in this
    public boolean isIn(E e) {return map.containsKey(e);}

    // return cardinality of this
    public int size() {return map.size();}

    // if this is empty throw ISE
    // else return arbitrary element of this
    public E choose() {
        if(map.size()==0) throw new IllegalStateException();
        List keys = new ArrayList(map.keySet());
        Collections.shuffle(keys);
        return (E)keys.get(0);
    }

    // conveniently, the <E,Integer> map is exactly the abstract state
    public String toString() {
        return map.toString();
    }

    public boolean repOK() {
        //EFFECTS: Returns true if the rep invariant holds for this
        //otherwise returns false
        for (Map.Entry<E, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 0) return false;
        }
        return true;
    }

}
