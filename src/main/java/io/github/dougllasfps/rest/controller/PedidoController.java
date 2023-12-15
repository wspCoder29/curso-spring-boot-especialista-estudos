package io.github.dougllasfps.rest.controller;

import io.github.dougllasfps.domain.Pedido;
import io.github.dougllasfps.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private Pedidos pedidosRepository;

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido novoPedido = pedidosRepository.save(pedido);
        return new ResponseEntity<>(novoPedido, HttpStatus.CREATED);
    }

}