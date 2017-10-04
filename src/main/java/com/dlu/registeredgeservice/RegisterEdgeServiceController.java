package com.dlu.registeredgeservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.stream.Collectors;


@RestController
@RibbonClient(name = "register-service", configuration = RegisterServiceConfiguration.class)
public class RegisterEdgeServiceController {


    @Autowired
    private RestTemplate restTemplate;


    @Autowired
    private UserServiceFeignClient userServiceFeignClient;


    @RequestMapping(method = RequestMethod.GET,value = "/register/{name}")
    private String register(@PathVariable String name){
        return restTemplate.getForObject("https://register-service/register/"+name, String.class);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public Collection<String> users(){
        return this.userServiceFeignClient.read().getContent().stream().map(User::getName).collect(Collectors.toList());
    }




}



