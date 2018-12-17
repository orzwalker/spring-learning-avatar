package com.walker.ioc.beanLifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * @author walker
 * @version 1.0
 * @since 2018-12-17 00:15
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    private static Logger logger = LoggerFactory.getLogger(MyInstantiationAwareBeanPostProcessor.class);

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            logger.info("InstantiationAwareBeanPostProcessor----postProcessBeforeInstantiation()方法...");
        }
        return null;
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            logger.info("InstantiationAwareBeanPostProcessor----postProcessAfterInstantiation()方法...");
        }
        return true;
    }

    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)){
            logger.info("InstantiationAwareBeanPostProcessor----postProcessPropertyValues()方法...");
        }
        return pvs;
    }

}
