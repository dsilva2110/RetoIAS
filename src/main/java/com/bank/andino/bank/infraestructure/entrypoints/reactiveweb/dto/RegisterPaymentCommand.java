package com.bank.andino.bank.infraestructure.entrypoints.reactiveweb.dto;

import com.bank.andino.bank.domain.model.enums.PaymentChannel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class RegisterPaymentCommand {

    private String obligationNumber;

    private Long amount;

    private String debitAccount;

    private PaymentChannel channel;

    private String idempotencyKey;

}
