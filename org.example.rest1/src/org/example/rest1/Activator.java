package org.example.rest1;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	private ServiceRegistration<ExampleResource> registration;

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		registration =bundleContext.registerService(ExampleResource.class, new ExampleResource(), null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		registration.unregister();
		Activator.context = null;
	}

}
