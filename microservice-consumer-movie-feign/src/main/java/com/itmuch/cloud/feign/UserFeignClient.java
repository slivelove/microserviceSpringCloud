package com.itmuch.cloud.feign;

import com.itmuch.config.Configuration1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itmuch.cloud.entity.User;

@FeignClient(name="microservice-provider-user",configuration = Configuration1.class)
public interface UserFeignClient {
  /*@RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
  User findById(@PathVariable("id") Long id); // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value

  @RequestMapping(value ="/user",method = RequestMethod.POST)
  User postUser(@RequestBody User user);*/

  @RequestLine("GET /simple/{id}")
  User findById(@Param("id") Long id);

}
