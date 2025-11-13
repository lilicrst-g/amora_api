package br.uern.cc.poo.amora_api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uern.cc.poo.amora_api.dto.BasketDto;
import br.uern.cc.poo.amora_api.dto.BasketRequest;
import br.uern.cc.poo.amora_api.dto.UserDto;
import br.uern.cc.poo.amora_api.dto.UserRequest;
import br.uern.cc.poo.amora_api.services.BasketService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Basket")
@RestController
@AllArgsConstructor
@RequestMapping("baskets")
public class BasketController {

    private BasketService service;

    @GetMapping
    @Operation(summary = "Listar todas as cestas do catálogo")
    public List<BasketDto> listAll() {
        return service.listAll();
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova cesta")
    public BasketDto create(@RequestBody BasketRequest request) {
        return service.create(request);
    }

    @GetMapping("{id}")
    @Operation(summary = "Buscar uma cesta pelo id")
    public ResponseEntity<BasketDto> findById(@PathVariable UUID id) {
        return service.findById(id)
                .map(dto -> ResponseEntity.ok(dto))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    @Operation(summary = "Editar cesta")
    public ResponseEntity<BasketDto> update(@PathVariable UUID id, @RequestBody BasketRequest request) {
        return service.update(id, request)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @Operation(summary = "Deletar a cesta")
    public ResponseEntity<BasketDto> delete(@PathVariable final UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
