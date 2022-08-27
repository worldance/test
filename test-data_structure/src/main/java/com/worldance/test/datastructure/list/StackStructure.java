package com.worldance.test.datastructure.list;

import java.util.LinkedList;
import java.util.List;

public class StackStructure {

    private LinkedList list;

    public StackStructure() {
        list = new LinkedList();
    }

    public Object getStackData() {
        //		return list.pollFirst();
        return list.pop();
    }

    public void setStackData(Object obj) {
        //		list.addFirst(obj);
        list.push(obj);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
