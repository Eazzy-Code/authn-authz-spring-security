package com.eazzycodeschool.autenticacaoautorizacao.users;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/signup")
class UserSignUpController {

	private final UserManager userManager;

	UserSignUpController(UserManager userManager) {
		this.userManager = userManager;
	}

	@PostMapping
	UserDto createUser(@RequestBody @Valid CreateUserParams createUserParams) {
		return this.userManager.create(createUserParams);
	}

}
