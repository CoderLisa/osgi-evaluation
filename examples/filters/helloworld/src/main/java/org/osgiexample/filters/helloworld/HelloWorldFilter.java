package org.osgiexample.filters.helloworld;

import org.osgiexample.bundle.DateService;

import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class HelloWorldFilter implements javax.servlet.Filter {

    DateService dateService;

    public HelloWorldFilter(DateService dateService) throws ServletException {
        this.dateService = dateService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filtering request");

        Date now = new Date();

        chain.doFilter(request, response);
        response.getWriter().write("Hello World.  Today is: " + dateService.getFormattedDate(now));
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}