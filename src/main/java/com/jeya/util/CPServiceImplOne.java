package com.jeya.util;

public class CPServiceImplOne implements CPService {

	@Override
	public void show() {
		System.out.println("CPServiceImplOne has been loaded");
	}

	@Override
	public boolean isDefault() {
		return true;
	}
}