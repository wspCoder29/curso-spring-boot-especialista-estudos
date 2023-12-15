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

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {
    private Integer cliente;
    private BigDecimal total;
    private List<ItemPedidoDTO> items;
}
