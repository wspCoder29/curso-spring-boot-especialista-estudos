package io.github.dougllasfps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import io.github.dougllasfps.domain.ItemPedido;

public interface ItemsPedido extends JpaRepository<ItemPedido,Integer> {
}
