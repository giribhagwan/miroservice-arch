package com.example.job_service.configs;

import brave.Tracer;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TraceIdResponseFilter implements Filter {
    private final Tracer tracer;
    public TraceIdResponseFilter(Tracer tracer) { this.tracer = tracer; }

    @Override public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        try {
            chain.doFilter(req, res);
        } finally {
            var current = tracer.currentSpan();
            if (current != null) {
                ((HttpServletResponse) res).setHeader("X-Trace-Id", current.context().traceIdString());
            }
        }
    }
}
