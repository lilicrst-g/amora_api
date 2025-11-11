package br.uern.cc.poo.amora_api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uern.cc.poo.amora_api.dto.AddressDto;
import br.uern.cc.poo.amora_api.services.AddressService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("addreses")
public class AddressController {

    private AddressService service;

    @GetMapping
    public List<AddressDto> listAll() {
        return service.listAll();
    }

}
