package br.com.api.authlogin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.authlogin.model.TransacaoPix;

@Repository
public interface TransacaoPixRepository extends JpaRepository<TransacaoPix, String> {
    // Outros métodos personalizados podem ser definidos aqui, se necessário
}
