package com.nasc.digitalAccount.dto;

import com.nasc.digitalAccount.model.enums.ClientStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDto {
    @Schema(description = "Client ID", example = "1", required = true)
    private Long id;
    @Schema(description = "Client name", example = "Joao Cancelo", required = true)
    private String name;
    @Schema(description = "Client CPF/CNPJ", example = "71301644684", required = true)
    private String document;
    @Schema(description = "Client email", example = "joao.cancelo@gmail.com", required = true)
    private String email;
    @Schema(description = "Client cellphone", example = "5511992458765", required = true)
    private String cellphone;
    @Schema(description = "Client address", example = "Rua Jose Carlos da Silva", required = true)
    private String address;
    @Schema(description = "Client status", example = "active", required = true)
    private ClientStatus status;
}
