package br.uern.cc.poo.amora_api.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.uern.cc.poo.amora_api.dto.AddressDto;
import br.uern.cc.poo.amora_api.dto.AddressRequest;
import br.uern.cc.poo.amora_api.dto.UserDto;
import br.uern.cc.poo.amora_api.dto.UserRequest;
import br.uern.cc.poo.amora_api.entities.User;
import br.uern.cc.poo.amora_api.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    private ModelMapper mapper;

    private AddressService addressService;

    public List<UserDto> listAll() {
        return repository.findAll().stream()
                .map(entity -> mapper.map(entity, UserDto.class))
                .toList();
    }

    public UserDto create(UserRequest request) {
        // Transformar DTO de entrada em entidade
        var entity = mapper.map(request, User.class);

        // Salvar
        var saved = repository.save(entity);

        // Transformar entidade salva em DTO de saída
        return mapper.map(saved, UserDto.class);
    }

    public Optional<UserDto> findById(UUID id) {
        return repository.findById(id)
                .map(entity -> mapper.map(entity, UserDto.class));
    }

    public Optional<UserDto> update(UUID id, UserRequest request) {
        return repository.findById(id)
                .map(entity -> {
                    mapper.map(request, entity);

                    var saved = repository.save(entity);

                    return mapper.map(saved, UserDto.class);
                });
    }

    public void delete(UUID id) {
        repository.deleteById(id);
        // deletar endereços desse usuário
    }

    public List<AddressDto> listAddresses(UUID id) {
        return repository.findById(id)
                .map(user -> user.getAddress().stream()
                        .map(address -> mapper.map(address, AddressDto.class))
                        .toList())
                .orElse(Collections.emptyList());
    }

    public Optional<AddressDto> createAddress(UUID id, AddressRequest request) {
        return repository.findById(id)
                .map(entity -> addressService.create(entity, request));
    }

}
