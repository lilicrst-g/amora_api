package br.uern.cc.poo.amora_api.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.uern.cc.poo.amora_api.dto.AddressDto;
import br.uern.cc.poo.amora_api.repositories.AddressRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository repository;

    private ModelMapper mapper;

    public List<AddressDto> listAll() {
        return repository.findAll().stream()
                .map(entity -> mapper.map(entity, AddressDto.class))
                .toList();
    }
}
