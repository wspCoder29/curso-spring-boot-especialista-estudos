package io.github.dougllasfps;

import io.github.dougllasfps.domain.Cliente;
import io.github.dougllasfps.domain.Pedido;
import io.github.dougllasfps.repository.Clientes;
import io.github.dougllasfps.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RestController
public class VendasApplication {

    @GetMapping("/hello")
    public String helloWorld() {
        return "hello world";
    }

    @Autowired
    Clientes clientes;


    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes, @Autowired Pedidos pedidos) {
        return args -> {

            System.out.println("Salvando clientes");
            Cliente cliente1 = new Cliente("Ada");
            clientes.save(cliente1);

            Pedido p1 = new Pedido();
            p1.setCliente(cliente1);
            p1.setDataPedido(LocalDate.now());
            p1.setTotal(BigDecimal.valueOf(666));
            pedidos.save(p1);

            Pedido p2 = new Pedido();
            p2.setCliente(cliente1);
            p2.setDataPedido(LocalDate.now());
            p2.setTotal(BigDecimal.valueOf(11));
            pedidos.save(p2);

            System.out.println("Cliente com os pedidos");
            Cliente cliente = clientes.findClienteFetchPedidos(cliente1.getId());

            System.out.println(cliente);

            pedidos.findByCliente(cliente).forEach(System.out::println);


        };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }


}
