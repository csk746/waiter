/**
 * 
 */
package com.daou.waiter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 */
@RequestMapping("/")
@RestController 
@Slf4j
public class HomeController {

	@RequestMapping("/**")
	public void homeRequest( HttpMethod method, HttpServletRequest request, HttpServletResponse response) {

	}
	
}
