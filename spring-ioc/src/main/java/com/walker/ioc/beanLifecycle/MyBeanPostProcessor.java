package com.walker.ioc.beanLifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author walker
 * @version 1.0
 * @since 2018-12-17 10:11
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    private static Logger logger = LoggerFactory.getLogger(MyBeanPostProcessor.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            Car car = (Car) bean;
            if (null == car.getColor()){
                logger.info("调用BeanPostProcessor的postProcessBeforeInitialization()方法，设置颜色为黑色...");
            }
            car.setColor("black");
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            Car car = (Car) bean;
            if (200 < car.getMaxSpeed()){
                logger.info("调用BeanPostProcessor的postProcessAfterInitialization()方法，设置最大速度为200...");
                car.setMaxSpeed(200);
            }
        }
        return bean;
    }
}
