package com.mactok.com.mactok.helloWorld;

import com.mactok.com.mactok.HelloWorld.HelloWorldBean;
import com.mactok.com.mactok.HelloWorld.HelloWorldController;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.MessageSource;

public class helloWorldBeanTest {

    @Test
    public void testHelloWorldBean(){
        HelloWorldController helloWorldController = new HelloWorldController();
        HelloWorldBean message = helloWorldController.HelloWorldBean();

        Assertions.assertEquals(message.getName(), "Hello World");
    }
}
