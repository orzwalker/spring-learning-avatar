package com.walker.ioc.resource;

import org.junit.Test;
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
    @Test
    public void getResources() throws IOException {
        ResourcePatternResolver resourcePatternResolver =new PathMatchingResourcePatternResolver();
        Resource resource = resourcePatternResolver.getResource("classpath:resource.xml");
        URL url = resource.getURL();
        System.out.println(url);
    }
}
