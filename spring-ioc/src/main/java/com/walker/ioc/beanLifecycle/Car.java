package com.walker.ioc.beanLifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author walker
 * @version 1.0
 * @since 2018-12-16 23:59
 */
public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private static Logger logger = LoggerFactory.getLogger(Car.class);

    private String brand;
    private String color;
    private Integer maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        logger.info("调用Car构造方法...");
    }

    public void setBrand(String brand) {
        logger.info("调用setBrand()方法设置属性...");
        this.brand = brand;
    }

    public void introduce() {
        logger.info(toString());
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", beanFactory=" + beanFactory +
                ", beanName='" + beanName + '\'' +
                '}';
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.info("调用BeanFactoryAware的setBeanFactor()方法...");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String beanName) {
        logger.info("BeanNameAware的setBeanName()方法...");
        this.beanName = beanName;
    }

    @Override
    public void destroy() throws Exception {
        logger.info("调用DisposableBean的destroy()方法...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("调用InitializingBean的afterPropertiesSet()方法...");
    }

    public void myInit() {
        logger.info("调用init-method所指定的myInit方法...");
        this.maxSpeed = 400;
    }

    public void myDestroy() {
        logger.info("调用destroy-method所指定的myDestroy()方法...");
    }
}
