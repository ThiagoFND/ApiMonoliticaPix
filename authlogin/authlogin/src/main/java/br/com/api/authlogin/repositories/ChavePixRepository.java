package br.com.api.authlogin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.authlogin.model.ChavePix;

public interface ChavePixRepository extends JpaRepository<ChavePix, String> {

}
