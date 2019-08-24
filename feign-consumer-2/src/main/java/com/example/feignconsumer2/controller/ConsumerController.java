package com.example.feignconsumer2.controller;

import com.example.feignconsumer2.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsumerController {

    Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloController() {
        logger.info("Request start...");
        String res = helloService.hello();
        logger.info("The Request end, response [{}]", res);
        return res;
    }
}
