package br.uern.cc.poo.amora_api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.uern.cc.poo.amora_api.entities.Address;
import br.uern.cc.poo.amora_api.repositories.AddressRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AddressService {

    private AddressRepository repository;

    public List<Address> listAll() {
        return repository.findAll();
    }
}
