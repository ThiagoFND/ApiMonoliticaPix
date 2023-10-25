package br.com.api.authlogin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.api.authlogin.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	UserDetails findByLogin(String login);
}
