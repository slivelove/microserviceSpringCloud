package com.itmuch.cloud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private EurekaClient eurekaClient;

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("/simple/{id}")
  public User findById(@PathVariable Long id) {
    return this.userRepository.findOne(id);
  }

  @GetMapping("/eureka-instance")
  public String serviceUrl() {
    InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
    return instance.getHomePageUrl();
  }

  /*@GetMapping("/instance-info")
  public ServiceInstance showInfo() {
    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
    return localServiceInstance;
  }*/

}
