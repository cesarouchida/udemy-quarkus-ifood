package com.clone.ifood.cadastro.dto;

import com.clone.ifood.cadastro.Restaurante;
import com.clone.ifood.cadastro.infra.DTO;
import com.clone.ifood.cadastro.infra.ValidDTO;

import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

@ValidDTO
public class AdicionarPratoDTO implements DTO {
    public String nome;
    public String descricao;
    public BigDecimal preco;

    @Override
    public boolean isValid(ConstraintValidatorContext constraintsConstraintValidatorContext) {
        return DTO.super.isValid(constraintsConstraintValidatorContext);
    }
}
