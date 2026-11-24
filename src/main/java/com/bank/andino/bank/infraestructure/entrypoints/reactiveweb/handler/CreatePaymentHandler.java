package com.bank.andino.bank.infraestructure.entrypoints.reactiveweb.handler;

import com.bank.andino.bank.domain.usecase.RegisterPaymentUseCase;
import com.bank.andino.bank.infraestructure.entrypoints.reactiveweb.dto.CreatePaymentRequest;
import com.bank.andino.bank.infraestructure.entrypoints.reactiveweb.dto.RegisterPaymentCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class CreatePaymentHandler {

    private RegisterPaymentUseCase registerPaymentUseCase;

    public Mono<ServerResponse> createPayment(ServerRequest request) {

        String obligationNumber =
                request.pathVariable("number");

        String idempotencyKey =
                request.headers()
                        .firstHeader("Idempotency-Key");

        return request.bodyToMono(CreatePaymentRequest.class)
                .flatMap(body -> {

                    RegisterPaymentCommand command =
                            RegisterPaymentCommand.builder()
                                    .obligationNumber(obligationNumber)
                                    .amount(body.getAmount())
                                    .debitAccount(body.getDebitAccount())
                                    .channel(body.getChannel())
                                    .idempotencyKey(idempotencyKey)
                                    .build();

                    return Mono.fromCallable(() ->
                                    registerPaymentUseCase.execute(command))
                            .flatMap(response ->
                                    ServerResponse.status(HttpStatus.CREATED)
                                            .bodyValue(response));
                });
    }
}
