package br.uern.cc.poo.amora_api.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.uern.cc.poo.amora_api.dto.BasketDto;
import br.uern.cc.poo.amora_api.dto.BasketRequest;
import br.uern.cc.poo.amora_api.entities.Basket;
import br.uern.cc.poo.amora_api.repositories.BasketRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BasketService {

    private BasketRepository repository;

    private ModelMapper mapper;

    public List<BasketDto> listAll() {
        return repository.findAll().stream()
                .map(entity -> mapper.map(entity, BasketDto.class))
                .toList();
    }

    public BasketDto create(BasketRequest request) {
        var entity = mapper.map(request, Basket.class);

        var saved = repository.save(entity);

        return mapper.map(saved, BasketDto.class);
    }

}
