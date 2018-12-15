package com.walker.ioc.beanFactory;

import com.walker.ioc.reflect.Car;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.net.URL;

/**
 * @author walker
 * @version 1.0
 * @since 2018-12-12 13:17
 */
public class BeanFactoryTest{

    private static Logger logger = LoggerFactory.getLogger(BeanFactoryTest.class);

    @Test
    public void getBean() throws IOException{
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:resource.xml");
        URL url = resource.getURL();
        logger.info(url.toString());

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

        logger.info("init factory...");

        Car car = factory.getBean("car", Car.class);
        logger.info("car beanLifecycle is ready for use...");
        car.introduce();

    }
}
