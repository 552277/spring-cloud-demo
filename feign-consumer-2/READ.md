
## 演示zipkin对于异常的显示情况：
1,当feign-consumer-2正常时，调用没有整合到zipkin服务的service-provider-2出现异常错误时：
1) zipkin中是否显示异常
答:显示异常，显示在调用feign-consumer-2服务中产生类似如下error信息
```
Request processing failed; nested exception is feign.FeignException: status 500 reading HelloService#hello(); 
content:{"timestamp":1566751446689,"status":500,"error":"Internal Server Error","exception":"java.lang.ArithmeticException","message":"/ by zero","path":"/hello"}
```
但是显示feign-consumer-2在第二阶段http.path:/hello中请求正常

2，当feign-consumer-2正常时，调用的整合到zipkin服务的service-provider出现异常错误时：
1) zipkin中是否显示异常
答:显示异常，feign-consumer-2阶段显示的异常信息如下：
```
Request processing failed; nested exception is feign.FeignException: status 500 reading HelloService#hello(); content:
{"timestamp":1566751860519,"status":500,"error":"Internal Server Error","exception":"java.lang.ArithmeticException","message":"/ by zero","path":"/hello"}
```
service-provider阶段显示的异常如下:
```
Request processing failed; nested exception is java.lang.ArithmeticException: / by zero
```
3，当feign-consumer-2报错时,在zipkin(http://localhost:9010/zipkin)上查看：
1) 是否能够看到请求在该服务中出现异常
可以
2) 是否还显示该请求的下游服务调用情况
如果调用后产生异常，则可以显示出下游的执行情况
如果调用前产生异常，没有请求下游服务，则不会显示下游服务执行情况
## 注意：
只有程序中抛出没有被处理的异常时，异常信息才会在zipkin中显示，如果是异常被捕获了或着是打印出的错误日志信息，是不会在zipkin中显示的