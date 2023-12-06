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

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
public class VendasApplication {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }

    @Autowired
    Clientes clientes;

    // Add this method
    public void printClientIdByName(String name) {
        Optional<Cliente> cliente = clientes.findByNome(name);
        if (cliente.isPresent()) {
            System.out.println("ID of " + name + " is: " + cliente.get().getId());
        } else {
            System.out.println("Cliente not found");
        }
    }

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes) {
        return args -> {
            clientes.save(new Cliente("Ada"));
            clientes.save(new Cliente("Mariana"));
            clientes.save(new Cliente("Carlos"));
            clientes.save(new Cliente("Beatriz"));
            clientes.save(new Cliente("Eduardo"));
            clientes.save(new Cliente("Fernanda"));
            clientes.save(new Cliente("Martha"));
            clientes.save(new Cliente("Helena"));
            clientes.save(new Cliente("Marilon"));
            clientes.save(new Cliente("João"));
            clientes.save(new Cliente("Lívia"));

            List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println();

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientes.save(c);
            });

//            System.out.println("Cliente Encontrado");
//            clientes.findByNomeLike("Isa").forEach(System.out::println);


//            System.out.println("Deletando clientes");
//            clientes.findAll().forEach(c->{
//                clientes.delete(c);
//            });


            todosClientes = clientes.findAll();
            if(todosClientes.isEmpty()){
                System.out.println("Sem clientes");
            }

            clientes.findAll();
            todosClientes.forEach(System.out::println);

            printClientIdByName("Martha atualizado.");




        };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }


}
