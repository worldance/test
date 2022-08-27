package com.worldance.test.datastructure.general;

/**
 * 泛型测试类，
 * 基本类型
 * extends implements
 *
 * @param <E>
 * @author 唐彬
 */
public class GenericClass<E> {

    public interface Animal {

    }

    public interface ChongChong {

    }

    public class dog implements Animal, ChongChong {

    }

    public class hotDog extends dog {

    }

}
