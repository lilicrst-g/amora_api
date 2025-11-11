package br.uern.cc.poo.amora_api.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.uern.cc.poo.amora_api.dto.OrderDto;
import br.uern.cc.poo.amora_api.repositories.OrderRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository repository;

    private ModelMapper mapper;

    public List<OrderDto> listAll() {
        return repository.findAll().stream()
                .map(entity -> mapper.map(entity, OrderDto.class))
                .toList();        
    }
}
