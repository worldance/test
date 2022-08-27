package com.worldance.test.testobjectstructure;

import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.VM;

@SpringBootTest
class TestObjectStructureApplicationTests {

    @Test
    void contextLoads() {
        Object o = new Object();
        StringBuffer o1 = new StringBuffer("ddd");
        System.out.println(ClassLayout.parseInstance(o1).toPrintable());

        o1.append("d号");
        System.out.println(ClassLayout.parseInstance(o1).toPrintable());
        System.out.println(ClassLayout.parseClass(StringBuffer.class).toPrintable());

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        synchronized (o) {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }

}
