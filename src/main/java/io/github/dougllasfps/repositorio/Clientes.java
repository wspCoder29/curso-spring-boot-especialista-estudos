package io.github.dougllasfps.repositorio;


import io.github.dougllasfps.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Clientes extends JpaRepository<Cliente, Integer> {
    List<Cliente> findByNomeLike(String nome);


    // Add this method
    Optional<Cliente> findByNome(String nome);




}



