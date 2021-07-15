package com.clone.ifood.cadastro.dto;

import com.clone.ifood.cadastro.Prato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

@Mapper(componentModel = "cdi")
public interface PratoMapper {

    Prato toPrato(AdicionarPratoDTO dto);

    void toPrato(AtualizarPratoDTO dto, @MappingTarget Prato prato);

    PratoDTO toPratoDTO(Prato prato);
}
