package com.walker.ioc.reflect;

import lombok.Getter;
import lombok.Setter;

/**
 * @author walker
 * @version 1.0
 * @since 2018-12-04 15:25
 */

public class Car {
    @Getter
    @Setter
    private String brand;

    @Getter
    @Setter
    private String color;

    @Getter
    @Setter
    private Integer maxSpeed;

    public void introduce() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Beans{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
