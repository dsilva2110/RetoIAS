package com.bank.andino.bank.domain.model;

import com.bank.andino.bank.domain.model.enums.ObligationStatus;
import com.bank.andino.bank.domain.model.enums.ObligationType;

import java.math.BigDecimal;

public class Obligation {

    private String number;
    private ObligationType type;

    private String customerDocument;
    private String debitAccount;

    private ObligationStatus status;
    private Integer daysPastDue;

    private BigDecimal overduePenaltyInterest;
    private BigDecimal overdueInsurance;
    private BigDecimal overdueCurrentInterest;
    private BigDecimal overduePrincipal;
    private BigDecimal outstandingPrincipal;

    private Long version;

    public boolean isCancelled() {
        return ObligationStatus.CANCELLED.equals(status);
    }

    public BigDecimal getTotalOverdueBalance() {
        return overduePenaltyInterest
                .add(overdueInsurance)
                .add(overdueCurrentInterest)
                .add(overduePrincipal);
    }

    public BigDecimal getTotalBalance() {
        return getTotalOverdueBalance()
                .add(outstandingPrincipal);
    }
}
