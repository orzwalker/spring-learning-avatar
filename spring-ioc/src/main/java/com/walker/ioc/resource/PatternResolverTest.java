package com.walker.ioc.resource;

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
 * @since 2018-12-05 19:04
 */
public class PatternResolverTest {

    private static final Logger logger = LoggerFactory.getLogger(PatternResolverTest.class);

    @Test
    public void getResources() throws IOException {
        ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource("classpath:resource.xml");
        URL url = resource.getURL();
        System.out.println(url);

        /** XmlBeanFactory在spring3.2中已被废弃，建议使用DefaultListableBeanFactory、XmlBeanDefinitionReader代替 */
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

        logger.info("init BeanFactory...");

        Car car = factory.getBean("car", Car.class);
        logger.info("car bean is ready for use...");
        car.introduce();
    }
}
