package org.osgiexample.embedded;


import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.osgi.framework.BundleException;
import org.osgi.framework.launch.Framework;
import org.osgi.framework.launch.FrameworkFactory;

public class EmbeddedOsgiLoader {

    public static void main(String[] args) throws BundleException {
        FrameworkFactory frameworkFactory = ServiceLoader.load(
                FrameworkFactory.class).iterator().next();
        Map<String, String> config = new HashMap<String, String>();

        Framework framework = frameworkFactory.newFramework(config);
        framework.start();
    }

}