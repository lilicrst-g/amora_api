package br.uern.cc.poo.amora_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uern.cc.poo.amora_api.dto.OrderDto;
import br.uern.cc.poo.amora_api.services.OrderService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("orders")
public class OrderController {

    private OrderService service;

    @GetMapping
    public List<OrderDto> listAll() {
        return service.listAll();
    }

}
