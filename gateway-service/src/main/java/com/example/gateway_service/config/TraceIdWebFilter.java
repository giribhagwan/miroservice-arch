package com.example.gateway_service.config;

import brave.Tracer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.*;

@Component
public class TraceIdWebFilter implements WebFilter {
    private final Tracer tracer;
    public TraceIdWebFilter(Tracer tracer) { this.tracer = tracer; }

    @Override
    public reactor.core.publisher.Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return chain.filter(exchange).doFinally(sig -> {
            var span = tracer.currentSpan();
            if (span != null) {
                ServerHttpResponse resp = exchange.getResponse();
                resp.getHeaders().add("X-Trace-Id", span.context().traceIdString());
            }
        });
    }
}
