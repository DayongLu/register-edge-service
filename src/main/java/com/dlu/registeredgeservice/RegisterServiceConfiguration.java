package com.dlu.registeredgeservice;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class RegisterServiceConfiguration {


    @Autowired
    IClientConfig ribbonClientConfig;


    @Bean
    public IPing ribbonPing(IClientConfig config){
        return new PingUrl();
    }

    @Bean
    public IRule ribbonRule(IClientConfig clientConfig){
        return new AvailabilityFilteringRule();
    }


}

class User {
    private String name;


    public String getName() {
        return name;
    }
}
