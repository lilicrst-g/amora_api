package br.uern.cc.poo.amora_api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("{id}")
    @Operation(summary = "Buscar um pedido pelo id")
    public ResponseEntity<OrderDto> findById(@PathVariable UUID id) {
        return service.findById(id)
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar o pedido")
    public ResponseEntity<OrderDto> delete(@PathVariable final UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
