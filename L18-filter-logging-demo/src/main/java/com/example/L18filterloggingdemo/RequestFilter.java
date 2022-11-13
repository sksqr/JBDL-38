package com.example.L18filterloggingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(Integer.MIN_VALUE)
public class RequestFilter extends HttpFilter {
    private Logger LOGGER = LoggerFactory.getLogger(RequestFilter.class);

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
       //Pre-processing
        MDC.put("requestId",request.getHeader("requestId"));
        MDC.put("userId",request.getHeader("userId"));

        LOGGER.info("Going to process request :{}",request.getRequestURI());
        long start = System.currentTimeMillis();
        filterChain.doFilter(request,response);
        long end = System.currentTimeMillis();
        LOGGER.info("Total time taken by :{} is {}",request.getRequestURI(), end-start);

        MDC.clear();

    }

}
