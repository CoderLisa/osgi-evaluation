package org.osgiexample.filters.helloworld;

import org.apache.felix.http.api.ExtHttpService;
import org.osgi.service.http.NamespaceException;
import org.osgiexample.service.date.DateService;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;


public class HelloWorldFilter implements javax.servlet.Filter {

    DateService dateService;
    ExtHttpService httpService;

    public void startup() throws ServletException, NamespaceException {
        System.out.println("registering helloworld blueprint filter");

        httpService.registerServlet("/", new SimpleServlet(), null, null);
        httpService.registerFilter(this, ".*", null, 0, null);
        System.out.println("httpService is " + httpService);
        System.out.println("date is " + dateService);
    }

    public HelloWorldFilter(DateService dateService, ExtHttpService httpService) {
        this.dateService = dateService;
        this.httpService = httpService;

        System.out.println("constructor helloworld blueprint filter");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("filtering request");

        Date now = new Date();

        System.out.println("dateService is" + dateService.getClass().getName());
        System.out.println("dateService dump" + dateService.toString());

        chain.doFilter(request, response);
        response.getWriter().write("Hello World\n" +
                dateService.getFormattedDate(now));
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init helloworld blueprint filter");
    }
}