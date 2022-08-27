package com.worldance.test.object.electronic.impl;

import com.worldance.test.object.electronic.ComputerInterface;

public class Computer implements ComputerInterface {
    protected String name;

    protected double price;

    public void printTest() {
        this.print();
    }

    public void print() {
        System.out.println("this is Computer!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
