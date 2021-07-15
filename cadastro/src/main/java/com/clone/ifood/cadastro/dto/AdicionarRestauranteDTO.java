package com.clone.ifood.cadastro.dto;

import com.clone.ifood.cadastro.Restaurante;
import com.clone.ifood.cadastro.infra.DTO;
import com.clone.ifood.cadastro.infra.ValidDTO;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.ConstraintValidatorContext;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ValidDTO
public class AdicionarRestauranteDTO implements DTO {
    @NotEmpty
    @NotNull
    public String proprietario;

    @CNPJ
    @NotNull
    public String cnpj;

    @Size(min=3, max=30)
    public String nomeFantasia;
    public LocalizacaoDTO localizacao;

    @Override
    public boolean isValid(ConstraintValidatorContext constraintsConstraintValidatorContext) {
        constraintsConstraintValidatorContext.disableDefaultConstraintViolation();
        if(Restaurante.find("cnpj", cnpj).count() > 0) {
            constraintsConstraintValidatorContext
                    .buildConstraintViolationWithTemplate("CNPJ já cadastrado")
                    .addPropertyNode("cnpj")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
