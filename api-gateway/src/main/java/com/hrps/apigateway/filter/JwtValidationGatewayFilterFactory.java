package com.hrps.apigateway.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;

public class JwtValidationGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    private final WebClient webClient;

    public JwtValidationGatewayFilterFactory(WebClient.Builder webClientBuilder,
            @Value("${auth.service.url}") String authServiceUrl) {
        webClient = webClientBuilder.baseUrl(authServiceUrl).build();
    }

    // Apply all this logic to every request (adds it to the request life cycle)
    @Override
    public GatewayFilter apply(Object config) {
        // exchange - holds all the properties for the current request (passed by gateway)
        // chain - manages the chain of filters that currently exist in the filter chain (we can implement multiple filters)
        return (exchange, chain) -> {
            String token = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

            if(token == null || !token.startsWith("Bearer ")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }

            return webClient.get()
                            .uri("/validate")
                            .header(HttpHeaders.AUTHORIZATION, token)       // set the request header
                            .retrieve()                                     // retrieve the response
                            .toBodilessEntity()                             // tell the client that there is no body in the resposne
                            .then(chain.filter(exchange));                  // if the request is successful (w/o exception), then continue the request
        };
    }
}
