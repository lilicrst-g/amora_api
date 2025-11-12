package br.uern.cc.poo.amora_api.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uern.cc.poo.amora_api.dto.AddressDto;
import br.uern.cc.poo.amora_api.dto.AddressRequest;
import br.uern.cc.poo.amora_api.dto.UserDto;
import br.uern.cc.poo.amora_api.dto.UserRequest;
import br.uern.cc.poo.amora_api.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "User")
@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private UserService service;

    @GetMapping
    @Operation(summary = "Listar todos os usuários")
    public List<UserDto> listAll() {
        return service.listAll();
    }

    @PostMapping
    @Operation(summary = "Criar um novo usuário")
    public UserDto create(@RequestBody UserRequest request) {
        return service.create(request);
    }

    @PostMapping("{id}/addresses")
    @Operation(summary = "Criar novo endereço vinculado ao usuário")
    public ResponseEntity<AddressDto> createAddress(@PathVariable UUID id, @RequestBody AddressRequest request) {
        // Chama o service pra cadastrar o endereço, recebe um opcional
        return service.createAddress(id, request)

                // Se o opcional vier preenchido, retornamos 201 (created)
                .map(dto -> ResponseEntity.status(201).body(dto))

                // Senão, retornamos 404 (not found)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("{id}/addresses")
    @Operation(summary = "Listar endereços por usuário")
    public ResponseEntity<List<AddressDto>> listAddresses(@PathVariable UUID id) {
        return ResponseEntity.ok(service.listAddresses(id));
    }
}
