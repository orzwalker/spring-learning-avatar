package com.walker.ioc.beanLifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author walker
 * @version 1.0
 * @since 2018-12-17 12:51
 */
public class BeanLifeCycle {

    private static Logger logger = LoggerFactory.getLogger(BeanLifeCycle.class);

    public static void lifeCycleInBeanFactory() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource("classpath:beans.xml");

        BeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) factory);
        reader.loadBeanDefinitions(resource);

        ((ConfigurableBeanFactory) factory).addBeanPostProcessor(new MyBeanPostProcessor());
        ((ConfigurableBeanFactory) factory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        Car car1 = (Car) factory.getBean("car");
        car1.introduce();
        car1.setColor("红色");

        Car car2 = (Car) factory.getBean("car");
        if (car1 == car2){
            logger.info("car1 == car2:");
        } else{
            logger.info("car1 != car2");
        }

        // 关闭容器
        ((DefaultListableBeanFactory) factory).destroySingletons();

    }

    public static void main(String[] args) throws IOException {
        lifeCycleInBeanFactory();
    }

}
