package br.uern.cc.poo.amora_api.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Service;

import br.uern.cc.poo.amora_api.dto.OrderDto;
import br.uern.cc.poo.amora_api.dto.OrderRequest;
import br.uern.cc.poo.amora_api.entities.Basket;
import br.uern.cc.poo.amora_api.entities.Order;
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

    public OrderDto create(OrderRequest request) {
        var entity = mapper
                .addMappings(new PropertyMap<OrderRequest, Order>() {
                    @Override
                    protected void configure() {
                        skip().setId(null);
                        skip().setBaskets(null);
                    }
                })                
                .map(request);

        var baskets = request.getBasketsIds().stream()
                .map(id -> {
                    var basket = new Basket();
                    basket.setId(id);
                    return basket;
                })
                .toList();

        entity.setBaskets(baskets);

        entity.setRequestDate(LocalDateTime.now());

        var saved = repository.save(entity);

        return mapper.map(saved, OrderDto.class);
    }

    public Optional<OrderDto> findById(UUID id) {
        return repository.findById(id)
                .map(entity -> mapper.map(entity, OrderDto.class));
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
