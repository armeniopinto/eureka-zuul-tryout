/**
 * ApplicationStarter.java
 * 
 * Copyright (C) 2016 by Arménio Pinto.
 * Please read LICENSE.TXT for the license details.
 */
package com.armeniopinto.time;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping("/time/{format}")
	public String time(@PathVariable String format) {
		final String time;
		if ("iso".equals(format)) {
			time = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mmX").withZone(ZoneOffset.UTC)
					.format(Instant.now());
		} else if ("unix".equals(format)) {
			time = Long.toString(System.currentTimeMillis());
		} else if ("pretty".equals(format)) {
			time = new Date().toString();
		} else {
			throw new IllegalArgumentException(String.format("Unkonwn date format: %s", format));
		}
		return time;
	}

	@ExceptionHandler
	public void handleUnkonwnDateFormat(final IllegalArgumentException iae,
			final HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value());
	}

}
