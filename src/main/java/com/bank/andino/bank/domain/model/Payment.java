package com.bank.andino.bank.domain.model;

import com.bank.andino.bank.domain.model.enums.PaymentChannel;
import com.bank.andino.bank.domain.model.enums.PaymentStatus;


import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {

    private UUID id;

    private String obligationNumber;

    private int amount;

    private PaymentChannel channel;

    private PaymentStatus status;

    private String coreReference;

    private String idempotencyKey;

    private LocalDateTime createdAt;
}
