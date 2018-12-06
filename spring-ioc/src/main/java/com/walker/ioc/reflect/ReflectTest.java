package com.walker.ioc.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author walker
 * @version 1.0
 * @since 2018-12-04 15:34
 */
public class ReflectTest {
    public static Car initByDefaultConst() throws Throwable {
        // 通过类加载器获取对象
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        // 以下三个loader存在父子层级关系
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
        Class clazz = loader.loadClass("com.walker.ioc.reflect.Car");
        System.out.println();
        // 通过默认的构造器获取实例
        Constructor constructor = clazz.getDeclaredConstructor((Class[])null);
        Car car = (Car) constructor.newInstance();

        // 通过反射设置属性
        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car, "benz");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "black");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", Integer.class);
        setMaxSpeed.invoke(car, 400);

        return car;
    }

    public static void main(String[] args) throws Throwable {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
