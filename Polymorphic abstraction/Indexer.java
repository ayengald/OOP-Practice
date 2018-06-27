package com.company;


import java.util.*;


public interface Indexer<E>{
    //OVERVIEW:  All subtypes of Indexer provide a means to search for
    // and element at a particular index in an arbitrary collection.

    public E get(int x) throws IndexOutOfBoundsException;
    //EFFECTS:  Throws IndexOutOfBoundsException if x is not in range of Indexes,
    // else, returns an element of the index that is equal to x.

    public int size();
    //EFFECTS:  returns the size of a collection as an int.
}

