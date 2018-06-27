package com.company;

import java.util.ArrayList;
import java.util.List;

public class ListIndexer<E> implements Indexer<E> {
    //OVERVIEW:  An arbitrary list of elements that implements the
    //  Indexer interface.

    //Variables
    public List<E> list;

    //Constructors
    public ListIndexer(){ list = new ArrayList<>();}

    public ListIndexer(List <E> listParam){
        list = listParam;
    }

    //Methods
    @Override
    public E get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    public void add(E e){
        list.add(e);
    }
}
