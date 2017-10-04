package com.dlu.registeredgeservice;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("register-service")
public interface UserServiceFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    Resources<User> read();

}
