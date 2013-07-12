package org.osgiexample.filters.helloworld;

import org.apache.felix.http.api.ExtHttpService;
import org.osgiexample.service.date.DateService;

import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class HelloWorldFilter implements javax.servlet.Filter {

    DateService dateService;
    ExtHttpService httpService;

    public void startup() throws ServletException {
        System.out.println("registering helloworld blueprint filter");
        httpService.registerFilter(this, ".*", null, 0, null);
        System.out.println("httpService is " + httpService);
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filtering request");

        Date now = new Date();

        chain.doFilter(request, response);
        response.getWriter().write("Hello World\n" +
                dateService.getFormattedDate(now));
    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init helloworld blueprint filter");
    }
}