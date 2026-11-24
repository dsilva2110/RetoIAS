package com.bank.andino.bank.infraestructure.postgresqlrepository.entities;

import com.bank.andino.bank.domain.model.enums.PaymentChannel;
import com.bank.andino.bank.domain.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "payments",
        indexes = {
                @Index(
                        name = "idx_payment_obligation_date",
                        columnList = "obligation_number,created_at"
                )
        },
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_payment_idempotency",
                        columnNames = "idempotency_key"
                )
        }
)
public class PaymentEntity {

    @Id
    private UUID id;

    @Column(name = "obligation_number", nullable = false)
    private String obligationNumber;

    @Column(nullable = false)
    private int amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentChannel channel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus status;

    @Column(name = "core_reference")
    private String coreReference;

    @Column(name = "idempotency_key", nullable = false)
    private String idempotencyKey;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
