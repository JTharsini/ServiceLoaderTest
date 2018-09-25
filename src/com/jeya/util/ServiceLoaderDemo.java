package com.jeya.util;

import java.util.ServiceLoader;

public class ServiceLoaderDemo {

	public CPService demo() {
		ServiceLoader<CPService> serviceLoader = ServiceLoader.load(CPService.class);
		return iterate(serviceLoader);
	}

	private CPService iterate(ServiceLoader<CPService> serviceLoader) {
		CPService nonDefault = null;
		for (CPService cpService : serviceLoader) {
			cpService.show();
			if(!cpService.isDefault())
			{
				nonDefault = cpService;
			}
		}
		return nonDefault;
	}
}