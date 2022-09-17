package com.nasc.digitalAccount.dto;

import com.nasc.digitalAccount.model.enums.ClientStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    @ApiModelProperty(notes = "Client ID", example = "1", required = true)
    private Long id;
    @ApiModelProperty(notes = "Client name", example = "Joao Cancelo", required = true)
    private String name;
    @ApiModelProperty(notes = "Client CPF/CNPJ", example = "71301644684", required = true)
    private String document;
    @ApiModelProperty(notes = "Client email", example = "joao.cancelo@gmail.com", required = true)
    private String email;
    @ApiModelProperty(notes = "Client cellphone", example = "5511992458765", required = true)
    private String cellphone;
    @ApiModelProperty(notes = "Client address", example = "Rua Jose Carlos da Silva", required = true)
    private String address;
    @ApiModelProperty(notes = "Client status", example = "active", required = true)
    private ClientStatus status;
}
