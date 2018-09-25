package com.jeya.util;

import java.util.ServiceLoader;

public class ServiceLoaderDemo {

	public CPService demo() {
		ServiceLoader<CPService> serviceLoader = ServiceLoader.load(CPService.class);
		return iterate(serviceLoader);
	}

	private CPService iterate(ServiceLoader<CPService> serviceLoader) {
		CPService nonDefault = null;
		boolean first = true;
		for (CPService cpService : serviceLoader) {
			if ((!first) && (!cpService.isDefault())) {
				nonDefault = cpService;
			} else if (first) {
				nonDefault = cpService;
				first = false;
			}
		}
		return nonDefault;
	}
}