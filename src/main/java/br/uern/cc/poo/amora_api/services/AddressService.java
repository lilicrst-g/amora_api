package br.uern.cc.poo.amora_api.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.uern.cc.poo.amora_api.dto.AddressDto;
import br.uern.cc.poo.amora_api.dto.AddressRequest;
import br.uern.cc.poo.amora_api.entities.Address;
import br.uern.cc.poo.amora_api.entities.User;
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

    public AddressDto create(User owner, AddressRequest request) {
        // Transformar DTO de entrada em entidade
        var entity = mapper.map(request, Address.class);

        // Atribuir usuário dono do endereço
        entity.setOwner(owner);

        // Salvar
        var saved = repository.save(entity);

        // Transformar entidade salva em DTO de saída
        return mapper.map(saved, AddressDto.class);
    }

    public Optional<AddressDto> findById(UUID id) {
        return repository.findById(id)
                .map(entity -> mapper.map(entity, AddressDto.class));
    }

}
