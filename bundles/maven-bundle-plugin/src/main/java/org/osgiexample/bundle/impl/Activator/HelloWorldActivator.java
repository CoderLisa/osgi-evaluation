package org.osgiexample.bundle.impl.Activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class HelloWorldActivator implements BundleActivator {

    public static BundleContext bundleContext = null;
    private HelloWorldThread thread = null;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("HelloWorldBundle starting...");
        HelloWorldActivator.bundleContext = bundleContext;
        thread = new HelloWorldThread();
        thread.start();

    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("HelloWorldBundle stopping...");
        HelloWorldActivator.bundleContext = null;
        thread.stopThread();
        thread.join();
    }
}
