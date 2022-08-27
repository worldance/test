package com.worldance.test.generic;

import com.worldance.test.object.electronic.ComputerInterface;
import com.worldance.test.object.electronic.ElectronicInterface;
import com.worldance.test.object.electronic.impl.Computer;
import com.worldance.test.object.electronic.impl.ThinkPadNotebook;
import com.worldance.test.object.shop.impl.ElectronicShop;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {

    }

    /**
     * 简单泛型
     */
    public void baseGenericTest() {
        List<ComputerInterface> computerList = new ArrayList<>();
        ThinkPadNotebook carbon1 = new ThinkPadNotebook();
        carbon1.setName("carbon1 X1");
        carbon1.setPrice(12000);
        computerList.add(carbon1);

        ThinkPadNotebook thinkpad1 = new ThinkPadNotebook();
        thinkpad1.setName("ThinkPad T470p");
        thinkpad1.setPrice(13470);
        computerList.add(thinkpad1);

        //        ElectronicShop<Computer> shop1 = new ElectronicShop<ThinkPadNotebook>(new ThinkPadNotebook());

        ElectronicShop<? extends Computer> shop2 = new ElectronicShop<Computer>(new Computer());
        Computer computer1 = shop2.getGoods();
        ElectronicInterface computer2 = shop2.getGoods();
        Object computer3 = shop2.getGoods();
        //        shop2.setGoods(new NotebookComputer()); //报错

        ElectronicShop<? super Computer> shop3 = new ElectronicShop<Computer>(new Computer());
        //        Computer computer21 = shop3.getGoods(); //报错

        Object computer33 = shop3.getGoods();
        shop3.setGoods(new ThinkPadNotebook());
    }

}
