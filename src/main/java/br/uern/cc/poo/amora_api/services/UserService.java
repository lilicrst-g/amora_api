package br.uern.cc.poo.amora_api.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

}
