package br.uern.cc.poo.amora_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uern.cc.poo.amora_api.dto.UserDto;
import br.uern.cc.poo.amora_api.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {

    private UserService service;

    @GetMapping
    public List<UserDto> listAll() {
        return service.listAll();
    }
}
