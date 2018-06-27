package com.company;

import java.util.*;

public class Search<E>{
//OVERVIEW:  A class that provides a search method for collection that extends the Indexer interface.

    public static <E> int search (Indexer<E> c, E x) throws NullPointerException, ClassNotFoundException {
        //EFFECTS: If c is null throws NullPointerException, else
        //  if x is in c returns an index where x can be found,
        //  else throws ClassNotFoundException

        if (c==null) throw new NullPointerException("SearchIndexer: search");

        Comparable val = (Comparable) x;
        for(int i = 0; i < c.size(); i++){
            if(c.get(i) == null) throw new NullPointerException();
            Comparable a = (Comparable) c.get(i);
            if(a.compareTo(val)  == 0){
                System.out.println("Generic found at index: " + i);
                return i;
            }
        }

        throw new ClassNotFoundException("Indexer.search");
    }


}


