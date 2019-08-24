package com.example.feignconsumer2.service;

import com.example.feignconsumer2.fallback.HelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "service-provider")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
