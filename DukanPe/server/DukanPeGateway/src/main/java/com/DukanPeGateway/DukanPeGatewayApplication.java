package com.DukanPeGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DukanPeGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DukanPeGatewayApplication.class, args);
	}

}
