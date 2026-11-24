package com.bank.andino.bank.infraestructure.postgresqlrepository.entities;

import com.bank.andino.bank.domain.model.enums.ObligationStatus;
import com.bank.andino.bank.domain.model.enums.ObligationType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "obligations")
public class ObligationEntity {

    @Id
    @Column(name = "number", nullable = false, length = 20)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private ObligationType type;

    @Column(name = "customer_document", nullable = false, length = 50)
    private String customerDocument;

    @Column(name = "debit_account", nullable = false, length = 30)
    private String debitAccount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private ObligationStatus status;

    @Column(name = "days_past_due", nullable = false)
    private Integer daysPastDue;

    @Column(
            name = "overdue_penalty_interest",
            nullable = false,
            precision = 19,
            scale = 0
    )
    private BigDecimal overduePenaltyInterest;

    @Column(
            name = "overdue_insurance",
            nullable = false,
            precision = 19,
            scale = 0
    )
    private BigDecimal overdueInsurance;

    @Column(
            name = "overdue_current_interest",
            nullable = false,
            precision = 19,
            scale = 0
    )
    private BigDecimal overdueCurrentInterest;

    @Column(
            name = "overdue_principal",
            nullable = false,
            precision = 19,
            scale = 0
    )
    private BigDecimal overduePrincipal;

    @Column(
            name = "outstanding_principal",
            nullable = false,
            precision = 19,
            scale = 0
    )
    private BigDecimal outstandingPrincipal;

    @Version
    private Long version;
}
