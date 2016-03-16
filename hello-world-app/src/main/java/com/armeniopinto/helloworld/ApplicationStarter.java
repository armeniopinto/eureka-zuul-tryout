/**
 * ApplicationStarter.java
 * 
 * Copyright (C) 2016 by Arménio Pinto.
 * Please read LICENSE.TXT for the license details.
 */
package com.armeniopinto.helloworld;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author armenio.pinto
 */
@SpringBootApplication
@RestController
public class ApplicationStarter {

	public static void main(final String[] args) {
		new SpringApplicationBuilder(ApplicationStarter.class).web(true).run(args);
	}

	@RequestMapping("/hello")
	public String hello() {
		return "Hello World!";
	}

}
