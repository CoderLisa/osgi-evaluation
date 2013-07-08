package org.osgiexample.filters.helloworld;

import org.apache.felix.http.api.ExtHttpService;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgiexample.bundle.DateService;

public class HelloWorldActivator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {

        System.out.println("registering the helloworld filter");
        ServiceReference sRef = context.getServiceReference(ExtHttpService.class.getName());
        ServiceReference dateServiceRef = context.getServiceReference(DateService.class.getName());
        if (sRef != null)
        {
            ExtHttpService service = (ExtHttpService) context.getService(sRef);

            DateService dateService = (DateService) context.getService(dateServiceRef);

            service.registerFilter(new HelloWorldFilter(dateService), ".*", null, 0, null);
        }
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
    }
}
