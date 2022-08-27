package com.worldance.test.datastructure.list;

public class StackDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        StackStructure stack = new StackStructure();

        stack.setStackData("hello");
        stack.setStackData("world");
        stack.setStackData("java");

        System.out.println(stack.getStackData());
        System.out.println(stack.getStackData());
        System.out.println(stack.getStackData());

        stack.setStackData("android");
        stack.setStackData("jdk");
        System.out.println(stack.getStackData());

        System.out.println(stack.getStackData());
    }

}
