package com.java.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/show/response")
	public ResponseEntity<String> printResponse() {
		
		return ResponseEntity.ok("Hello World................");
	}
}
