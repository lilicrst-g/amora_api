package br.uern.cc.poo.amora_api.entities;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.SoftDelete;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "baskets")
@SoftDelete
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;
    
    @Column(nullable = false)
    private String description;

    @Column
    private String photoId;

    @ManyToMany(mappedBy = "baskets")
    private List<Order> orders;

}
