package com.walker.ioc.applicationContext;

import com.walker.ioc.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author walker
 * @version 1.0
 * @since 2018-12-15 15:28
 */
@Configuration
public class Beans {
    // @Bean可指定bean的ID，value="xxx"，默认是空
    @Bean(value = "car")
    public Car buildCar(){
        Car car  = new Car();
        car.setBrand("xxx");
        car.setColor("red");
        car.setMaxSpeed(333);
        return car;
    }
}
