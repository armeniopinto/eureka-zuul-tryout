/**
 * ApplicationStarter.java
 * 
 * Copyright (C) 2016 by Arménio Pinto.
 * Please read LICENSE.TXT for the license details.
 */
package com.armeniopinto.mirror;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author armenio.pinto
 */
@SpringBootApplication
@EnableEurekaServer
public class ApplicationStarter {

	public static void main(final String[] args) {
		new SpringApplicationBuilder(ApplicationStarter.class).run(args);
	}

}
