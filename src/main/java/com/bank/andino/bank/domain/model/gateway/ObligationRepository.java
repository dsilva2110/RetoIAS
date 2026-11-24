package com.bank.andino.bank.domain.model.gateway;

import reactor.core.publisher.Mono;

public interface ObligationRepository {

    Mono<Transfer> save(Transfer transfer);
}
