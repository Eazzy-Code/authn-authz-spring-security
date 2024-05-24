package com.eazzycodeschool.autenticacaoautorizacao.users;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManager {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

	public UserManager(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public UserDto create(CreateUserParams params) {
		validateParams(params);
		User user = new User();
		user.setEmail(params.email());
		String encodedPassword = this.passwordEncoder.encode(params.password());
		user.setPassword(encodedPassword);
		user.setEnabled(true);
		user.addRole(new Role(RoleNames.ROLE_USER));
		User saved = this.userRepository.save(user);
		return new UserDto(saved.getEmail(), saved.isEnabled());
	}

	private void validateParams(CreateUserParams params) {
		boolean userExists  = this.userRepository.existsByEmail(params.email());
		if (userExists) {
			throw new IllegalArgumentException("Usuário existente");
		}
	}
}
