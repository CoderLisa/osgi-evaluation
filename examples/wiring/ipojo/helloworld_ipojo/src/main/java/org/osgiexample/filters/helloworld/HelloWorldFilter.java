package org.osgiexample.filters.helloworld;

import org.apache.felix.http.api.ExtHttpService;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgiexample.bundle.DateService;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;



public class HelloWorldFilter implements javax.servlet.Filter {

    private DateService dateService;

    public HelloWorldFilter(BundleContext ctx) throws ServletException {
        ServiceReference sRef = ctx.getServiceReference(ExtHttpService.class.getName());
        if (sRef != null)
        {
            ExtHttpService service = (ExtHttpService) ctx.getService(sRef);
            service.registerFilter(this, ".*", null, 0, null);
        }
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
    }
}