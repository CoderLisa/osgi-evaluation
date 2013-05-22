package org.osgiexample.bundle.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgiexample.bundle.DateService;

import java.util.Hashtable;

public class Activator implements BundleActivator {

    public static BundleContext bundleContext = null;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println(bundleContext.getBundle().getHeaders().get
                (Constants.BUNDLE_NAME) + " starting...");

        Activator.bundleContext = bundleContext;

        DateService service = new DateServiceImpl();
        bundleContext.registerService(DateService.class.getName(), service, new Hashtable());
        System.out.println("Service registered: DateService");
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println(bundleContext.getBundle().getHeaders().get
                (Constants.BUNDLE_NAME) + " stopping...");
        Activator.bundleContext = null;
    }
}
