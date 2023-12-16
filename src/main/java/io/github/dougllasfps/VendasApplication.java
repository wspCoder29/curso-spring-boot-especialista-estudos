package io.github.dougllasfps;

import io.github.dougllasfps.domain.Cliente;
import io.github.dougllasfps.domain.Produto;
import io.github.dougllasfps.repository.Clientes;
import io.github.dougllasfps.repository.Produtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes,
                                  @Autowired Produtos produtos) {
        return args -> {
            clientes.save(new Cliente("Ada", "666"));
            clientes.save(new Cliente("Mariana", "333"));

            produtos.save(new Produto("Abajourjj", new BigDecimal(100)));
            produtos.save(new Produto("PC", new BigDecimal(3335)));
            produtos.save(new Produto("Telefonejj", new BigDecimal(999)));
            produtos.save(new Produto("Sapato", new BigDecimal(45)));

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}


