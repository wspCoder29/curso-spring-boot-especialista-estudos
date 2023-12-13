package io.github.dougllasfps.repository;

import io.github.dougllasfps.domain.Cliente;
import io.github.dougllasfps.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    @Query("SELECT p FROM Pedido p WHERE p.cliente = :cliente")
    List<Pedido> findByCliente(Cliente cliente);





}
