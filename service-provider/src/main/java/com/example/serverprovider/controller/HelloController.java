package com.example.serverprovider.controller;

import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
//        logger.error("该条信息是通过logger打印出来的错误日志");
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:[{}] , service_id: [{}], port: [{}]", instance.getHost(), instance.getServiceId(), instance.getPort());
        return "Hello World, I'm " + instance.getPort();
    }

    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello(@RequestBody User user) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:[{}] , service_id: [{}], port: [{}]", instance.getHost(), instance.getServiceId(), instance.getPort());
        return "Hello " + user.getUsername() + ", " + user.getRoles();
    }
}
