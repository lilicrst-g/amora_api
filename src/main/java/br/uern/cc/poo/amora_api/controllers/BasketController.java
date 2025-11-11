package br.uern.cc.poo.amora_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uern.cc.poo.amora_api.dto.BasketDto;
import br.uern.cc.poo.amora_api.dto.BasketRequest;
import br.uern.cc.poo.amora_api.services.BasketService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("baskets")
public class BasketController {

    private BasketService service;

    @GetMapping
    public List<BasketDto> listAll() {
        return service.listAll();
    }

    @PostMapping
    public BasketDto create(@RequestBody BasketRequest request) {
        return service.create(request);
    }
}
