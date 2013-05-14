package org.osgiexample.bundle.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceReference;
import org.osgiexample.bundle.DateService;

import java.util.Date;
import java.util.Hashtable;

public class Activator implements BundleActivator {

    public static BundleContext bundleContext = null;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println(bundleContext.getBundle().getHeaders().get
                (Constants.BUNDLE_NAME) + " starting...");

        Activator.bundleContext = bundleContext;

        ServiceReference reference = bundleContext.getServiceReference(DateService.class.getName());

        DateService service = (DateService)bundleContext.getService(reference);

        System.out.println("Using DateService: formatting date: " + service.getFormattedDate(new Date()));

        bundleContext.registerService(DateService.class.getName(), service, new Hashtable());

        bundleContext.ungetService(reference);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println(bundleContext.getBundle().getHeaders().get
                (Constants.BUNDLE_NAME) + " stopping...");
        Activator.bundleContext = null;
    }
}
