package com.itmuch.cloud.feign;

import com.itmuch.config.Configuration2;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="xxxx",configuration = Configuration2.class,url = "http://localhost:8761/")
public interface FeignClient2 {
    @RequestMapping(value = "/eureka/apps/{serviceName}")
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
