package br.uern.cc.poo.amora_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uern.cc.poo.amora_api.entities.Basket;
import br.uern.cc.poo.amora_api.services.BasketService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("baskets")
public class BasketController {

    private BasketService service;

    @GetMapping
    public List<Basket> listAll() {
        return service.listAll();
    }
}
