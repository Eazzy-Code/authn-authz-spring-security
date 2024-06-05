package com.eazzycodeschool.autenticacaoautorizacao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

	@GetMapping("/hello")
	String hello() {
		return "hello";
	}

	@PostMapping("/login")
	void login() {

	}

}
