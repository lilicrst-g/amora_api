package br.uern.cc.poo.amora_api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        // Criar objeto
        final var modelMapper = new ModelMapper();

        // Configurar
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true);

        return modelMapper;
    }
}
