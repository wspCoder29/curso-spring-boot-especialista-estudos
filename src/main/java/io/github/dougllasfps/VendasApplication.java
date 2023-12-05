package io.github.dougllasfps;

import io.github.dougllasfps.domain.Cliente;
import io.github.dougllasfps.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            clientes.salvar(new Cliente("Ada"));
            clientes.salvar(new Cliente("Mona"));
            clientes.salvar(new Cliente("Carlos"));
            clientes.salvar(new Cliente("Beatriz"));
            clientes.salvar(new Cliente("Eduardo"));
            clientes.salvar(new Cliente("Fernanda"));
            clientes.salvar(new Cliente("Gustavo"));
            clientes.salvar(new Cliente("Helena"));
            clientes.salvar(new Cliente("Isabela"));
            clientes.salvar(new Cliente("João"));
            clientes.salvar(new Cliente("Lívia"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

        };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }


}
