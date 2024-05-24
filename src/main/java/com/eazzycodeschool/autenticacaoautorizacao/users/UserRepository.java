package com.eazzycodeschool.autenticacaoautorizacao.users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

	boolean existsByEmail(String email);

}
