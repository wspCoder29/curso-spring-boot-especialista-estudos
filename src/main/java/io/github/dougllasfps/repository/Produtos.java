package io.github.dougllasfps.repository;

import io.github.dougllasfps.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {
}
