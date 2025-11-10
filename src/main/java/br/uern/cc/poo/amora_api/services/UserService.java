package br.uern.cc.poo.amora_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.uern.cc.poo.amora_api.entities.User;
import br.uern.cc.poo.amora_api.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    public List<User> listAll() {
        return repository.findAll();
    }
}
