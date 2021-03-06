package org.osgiexample.servlet;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpService;

public class ServletActivator implements BundleActivator {

    public void start(BundleContext context) throws Exception
    {
        System.out.println("registering the simple servlet");
        ServiceReference sRef = context.getServiceReference(HttpService.class.getName());
        if (sRef != null)
        {
            HttpService service = (HttpService) context.getService(sRef);
            service.registerServlet("/", new SimpleServlet(), null, null);
            System.out.println("httpService is " + service);
        }

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
    }

}
