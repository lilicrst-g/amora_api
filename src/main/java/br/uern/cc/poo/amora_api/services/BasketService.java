package br.uern.cc.poo.amora_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.uern.cc.poo.amora_api.entities.Basket;
import br.uern.cc.poo.amora_api.repositories.BasketRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BasketService {

    private BasketRepository repository;

    public List<Basket> listAll() {
        return repository.findAll();
    }

}
