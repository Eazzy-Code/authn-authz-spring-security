package com.eazzycodeschool.autenticacaoautorizacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;

@TestConfiguration(proxyBeanMethods = false)
@Import(TestcontainersConfig.class)
public class TestApplication {

	public static void main(String[] args) {
		SpringApplication.from(AutenticacaoAutorizacaoSpringSecurityApplication::main).with(TestApplication.class).run(args);
	}

}
