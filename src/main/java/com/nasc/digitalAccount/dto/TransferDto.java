package com.nasc.digitalAccount.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferDto {
    private String sourceAgency;
    private String sourceAccountNumber;
    private String destinationAgency;
    private String destinationAccountNumber;
    private String sourceCellphone;
    private String destinationCellphone;
    private BigDecimal amount;
}
