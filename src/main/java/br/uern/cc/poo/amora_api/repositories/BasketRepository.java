package br.uern.cc.poo.amora_api.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.uern.cc.poo.amora_api.entities.Basket;

@Repository
public interface BasketRepository extends JpaRepository<Basket, UUID> {

}
