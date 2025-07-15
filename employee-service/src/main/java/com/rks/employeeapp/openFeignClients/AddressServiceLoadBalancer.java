package com.rks.employeeapp.openFeignClients;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;

//@LoadBalancerClient(value = "ADDRESS-SERVICE",configuration = MyCoustomLoadBalancerConfiguration.class)
@LoadBalancerClient(value = "ADDRESS-SERVICE")
public class AddressServiceLoadBalancer {

		// This class is used to configure the load balancer for the Address Service.
	// It can be used to customize the load balancing strategy or configuration if needed.

	@LoadBalanced
	@Bean
	public Feign.Builder feignBuilder() {
		return Feign.builder();
	}
}
