package com.example.feignconsumer2.fallback;

import com.example.feignconsumer2.service.HelloService;

public class HelloServiceFallback implements HelloService {
    @Override
    public String hello() {
        return "Something went wrong";
    }
}
