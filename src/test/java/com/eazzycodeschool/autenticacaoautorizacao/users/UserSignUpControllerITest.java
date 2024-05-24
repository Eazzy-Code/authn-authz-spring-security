package com.eazzycodeschool.autenticacaoautorizacao.users;

import com.eazzycodeschool.autenticacaoautorizacao.TestcontainersConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(TestcontainersConfig.class)
@AutoConfigureMockMvc
class UserSignUpControllerITest {

	@Autowired
	MockMvc mvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	void createUserWhenValidParamsThenCreated() throws Exception {
		CreateUserParams params = new CreateUserParams("meu@email.com", "minhasenha");
		this.mvc
				.perform(post("/auth/signup")
						.contentType(MediaType.APPLICATION_JSON)
						.content(this.objectMapper.writeValueAsBytes(params)))
				.andExpectAll(
						status().isOk(),
						jsonPath("$.email").value("meu@email.com"),
						jsonPath("$.enabled").value(true)
				);
	}

}