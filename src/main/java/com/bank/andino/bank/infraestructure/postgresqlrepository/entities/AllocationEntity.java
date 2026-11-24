package com.bank.andino.bank.infraestructure.postgresqlrepository.entities;

import com.bank.andino.bank.domain.model.enums.AllocationConcept;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "allocations")
public class AllocationEntity {

    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "payment_id",
            nullable = false
    )
    private PaymentEntity payment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AllocationConcept concept;

    @Column(nullable = false)
    private BigDecimal amount;
}
