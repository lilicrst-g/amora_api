package br.uern.cc.poo.amora_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uern.cc.poo.amora_api.dto.OrderDto;
import br.uern.cc.poo.amora_api.dto.OrderRequest;
import br.uern.cc.poo.amora_api.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Order")
@RestController
@AllArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private OrderService service;

    @GetMapping
    @Operation(summary = "Listar todos os pedidos")
    public List<OrderDto> listAll() {
        return service.listAll();
    }

    @PostMapping
    @Operation(summary = "Cadastrar novo pedido")
    public OrderDto create(@RequestBody OrderRequest request) {
        return service.create(request);
    }

}
