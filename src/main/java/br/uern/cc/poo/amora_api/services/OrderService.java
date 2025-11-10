package br.uern.cc.poo.amora_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.uern.cc.poo.amora_api.entities.Order;
import br.uern.cc.poo.amora_api.repositories.OrderRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository repository;

    public List<Order> listAll() {
        return repository.findAll();
    }
}
