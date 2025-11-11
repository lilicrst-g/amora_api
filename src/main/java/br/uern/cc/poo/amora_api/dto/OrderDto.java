package br.uern.cc.poo.amora_api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Value;

@Value
public class OrderDto {

    private UUID id;
    private String status;
    private LocalDateTime requestDate;
    private LocalDateTime dateToDeliver;
    private UserDto user;
    private List<BasketDto> baskets;
    private AddressDto address;

}
