package com.pesol.webapp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Test")
public class TestController {

	@GetMapping
	public String test(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(request.getServerName());
		
		return "test-page"; // assume
	}
}
