package br.uern.cc.poo.amora_api.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class OrderRequest {

    @NotNull
    @Future
    private LocalDateTime dateToDeliver;

    @NotEmpty
    private List<UUID> basketsIds;

    private UUID addressId;

}
