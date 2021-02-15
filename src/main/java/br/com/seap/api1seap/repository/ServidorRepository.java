package br.com.seap.api1seap.repository;

import br.com.seap.api1seap.model.Servidor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServidorRepository extends JpaRepository<Servidor, Long> {

    Optional<Servidor> findOneById(Long id);
}
