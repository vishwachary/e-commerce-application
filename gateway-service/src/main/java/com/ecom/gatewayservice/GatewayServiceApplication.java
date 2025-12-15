package com.ecom.gatewayservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayServiceApplication {

    static Logger logger = LoggerFactory.getLogger(GatewayServiceApplication.class);

	public static void main(String[] args) {
        logger.info("Congrats your Request is being served via GatewayServiceApplication");
        SpringApplication.run(GatewayServiceApplication.class, args);
	}

}
