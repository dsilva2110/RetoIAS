package com.bank.andino.bank.infraestructure.entrypoints.reactiveweb.router;

import com.bank.andino.bank.infraestructure.entrypoints.reactiveweb.handler.CreatePaymentHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class PaymentRouter {

    private final CreatePaymentHandler createPaymentHandler;

    @Bean
    public RouterFunction<ServerResponse> paymentRoutes() {

        return RouterFunctions.route(
                RequestPredicates.POST("/obligations/{number}/payments"),
                createPaymentHandler::createPayment
        );
    }

}
