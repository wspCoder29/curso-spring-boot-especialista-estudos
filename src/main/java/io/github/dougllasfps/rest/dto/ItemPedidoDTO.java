package io.github.dougllasfps.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ItemPedidoDTO {
    private Integer produto;
    private Integer quantidade;
}
