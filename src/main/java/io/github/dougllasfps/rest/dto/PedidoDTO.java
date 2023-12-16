package io.github.dougllasfps.rest.dto;

//    {
//        "cliente": 1,
//            "total": 100,
//            "items":[
//        {
//            "produto":1,
//                "quantidade":10
//        }
//    ]
//    }

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PedidoDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> items;
}
