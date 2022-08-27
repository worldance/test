package com.worldance.test.object.test;

import com.worldance.test.object.electronic.impl.Computer;
import com.worldance.test.object.electronic.impl.NotebookComputer;

public class ElectronicTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Computer com = new NotebookComputer();
        com.printTest();
        com.print();
    }

}
