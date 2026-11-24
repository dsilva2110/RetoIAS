package com.bank.andino.bank.infraestructure.entrypoints.reactiveweb.dto;

import com.bank.andino.bank.domain.model.enums.PaymentChannel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreatePaymentRequest {

    private Long amount;

    private PaymentChannel channel;

    private String debitAccount;

}

