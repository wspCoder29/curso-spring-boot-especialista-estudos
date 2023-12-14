package io.github.dougllasfps.rest.controller;

import io.github.dougllasfps.domain.Cliente;
import io.github.dougllasfps.repository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClienteController {

    private Clientes clientes;

    public ClienteController( Clientes clientes ) {
        this.clientes = clientes;
    }

    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity getClienteById( @PathVariable Integer id ){
        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent()){
            return ResponseEntity.ok( cliente.get() );
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity save( @RequestBody Cliente cliente ){
        Cliente clienteSalvo = clientes.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity delete( @PathVariable Integer id ){
        Optional<Cliente> cliente = clientes.findById(id);

        if(cliente.isPresent()){
            clientes.delete( cliente.get() );
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity update(
            @PathVariable Integer id, @RequestBody Cliente cliente){
        return clientes
                    .findById(id)
                    .map( clienteEncontrado -> {
                        clienteEncontrado.setNome(cliente.getNome());
                        clientes.save(clienteEncontrado);
                        return ResponseEntity.noContent().build();
                    }).orElseGet(() -> ResponseEntity.notFound().build());


    }

    @GetMapping("/api/clientes")
    @ResponseBody
    public ResponseEntity find( Cliente cliente ){

        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Cliente> example = Example.of(cliente, matcher);

        List<Cliente> list = clientes.findAll(example);
        return ResponseEntity.ok(list);
    }

}
