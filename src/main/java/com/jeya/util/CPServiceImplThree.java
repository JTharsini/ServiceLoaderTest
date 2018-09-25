package com.jeya.util;

public class CPServiceImplThree implements CPService {

	@Override
	public void show() {
		System.out.println("CPServiceImplThree has been loaded");
	}

	@Override
	public boolean isDefault() {
		return false;
	}
}