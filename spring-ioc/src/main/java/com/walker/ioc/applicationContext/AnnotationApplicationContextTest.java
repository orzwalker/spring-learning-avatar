package com.walker.ioc.applicationContext;

import com.walker.ioc.reflect.Car;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author walker
 * @version 1.0
 * @since 2018-12-15 15:32
 */
public class AnnotationApplicationContextTest {
    @Test
    public void getBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Beans.class);
        Car car = applicationContext.getBean("car", Car.class);
        car.introduce();

    }
}
