package com.nasc.digitalAccount.model;

import com.nasc.digitalAccount.model.enums.TransactionType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "transaction_statements")
@Getter
@Setter
public class TransactionStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "transaction_type", nullable = false)
    private TransactionType transactionType;

    @Column(name = "transaction_value", nullable = false)
    private BigDecimal transactionValue;

    @Column(name = "transaction_date", nullable = false)
    private String transactionDate;

    @ManyToOne
    @JoinColumn(name="fk_account_id", nullable = false)
    private Account account;

}