package com.bank.andino.bank.domain.usecase;

import com.bank.andino.bank.domain.model.PaymentResponse;
import com.bank.andino.bank.domain.model.gateway.ObligationRepository;
import com.bank.andino.bank.infraestructure.entrypoints.reactiveweb.dto.RegisterPaymentCommand;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegisterPaymentUseCase {

    private final ObligationRepository obligationRepository;

    public PaymentResponse execute(
            RegisterPaymentCommand command) {

        // lógica

        return null;
    }
}
