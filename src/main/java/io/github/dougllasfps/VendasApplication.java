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
            clientes.salvar(new Cliente("Mariana"));
            clientes.salvar(new Cliente("Carlos"));
            clientes.salvar(new Cliente("Beatriz"));
            clientes.salvar(new Cliente("Eduardo"));
            clientes.salvar(new Cliente("Fernanda"));
            clientes.salvar(new Cliente("Martha"));
            clientes.salvar(new Cliente("Helena"));
            clientes.salvar(new Cliente("Marilon"));
            clientes.salvar(new Cliente("João"));
            clientes.salvar(new Cliente("Lívia"));

            List<Cliente> todosClientes = clientes.obterTodos();
            todosClientes.forEach(System.out::println);

            System.out.println();

            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado.");
                clientes.atualizar(c);
            });

            System.out.println("Cliente Encontrado");
            clientes.buscarPorNome("Isa").forEach(System.out::println);


//            System.out.println("Deletando clientes");
//            clientes.obterTodos().forEach(c->{
//                clientes.deletar(c);
//            });

            todosClientes.forEach(c->{
                clientes.deletarPorNomeIniciandoCom("Ma");
            });

            todosClientes = clientes.obterTodos();
            if(todosClientes.isEmpty()){
                System.out.println("Sem clientes");
            }


            clientes.obterTodos();
            todosClientes.forEach(System.out::println);



        };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }


}
