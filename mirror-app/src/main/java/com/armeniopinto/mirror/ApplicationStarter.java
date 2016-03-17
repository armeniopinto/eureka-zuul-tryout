/**
 * ApplicationStarter.java
 * 
 * Copyright (C) 2016 by Arménio Pinto.
 * Please read LICENSE.TXT for the license details.
 */
package com.armeniopinto.mirror;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author armenio.pinto
 */
@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class ApplicationStarter {

	public static void main(final String[] args) {
		new SpringApplicationBuilder(ApplicationStarter.class).web(true).run(args);
	}

	@RequestMapping("/mirror")
	public String mirror(@RequestBody String text) {
		return new StringBuilder(text).reverse().toString();
	}

}
