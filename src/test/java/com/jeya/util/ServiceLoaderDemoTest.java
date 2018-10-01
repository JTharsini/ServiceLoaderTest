package com.jeya.util;

import org.fest.reflect.core.Reflection;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.testng.PowerMockTestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

@PrepareForTest(ServiceLoaderDemo.class)
public class ServiceLoaderDemoTest extends PowerMockTestCase {
	private ServiceLoaderDemo serviceLoaderDemo = new ServiceLoaderDemo();

	private ServiceLoader mockServiceLoader;
	
	@Test
	public void testIterate_oneDefaultOnly() {
		mockServiceLoader = PowerMockito.mock(ServiceLoader.class);
		CPService defaultPlugin = PowerMockito.mock(CPService.class);
		Mockito.when(defaultPlugin.isDefault()).thenReturn(true);

		List<CPService> mutableList = new ArrayList<>();
		mutableList.add(defaultPlugin);
		
		List<CPService> immutableList = Collections.unmodifiableList(mutableList);
		
		Mockito.when(mockServiceLoader.iterator()).thenReturn(immutableList.iterator());
		CPService methodToTest = null;
		try {
			methodToTest = Reflection.method("iterate").withReturnType(CPService.class).withParameterTypes(ServiceLoader.class)
					.in(serviceLoaderDemo).invoke(mockServiceLoader);
		} catch (SecurityException e) {
			Assert.fail();
		}
		Assert.assertEquals(methodToTest, defaultPlugin);
	}
	
	@Test
	public void testIterate_oneNonDefaultOnly() {
		mockServiceLoader = PowerMockito.mock(ServiceLoader.class);
		
		CPService nonDefaultPlugin1 = PowerMockito.mock(CPService.class);
		Mockito.when(nonDefaultPlugin1.isDefault()).thenReturn(false);
		
		List<CPService> mutableList = new ArrayList<>();
		mutableList.add(nonDefaultPlugin1);
		
		List<CPService> immutableList = Collections.unmodifiableList(mutableList);
		
		Mockito.when(mockServiceLoader.iterator()).thenReturn(immutableList.iterator());
		CPService methodToTest = null;
		try {
			methodToTest = Reflection.method("iterate").withReturnType(CPService.class).withParameterTypes(ServiceLoader.class)
					.in(serviceLoaderDemo).invoke(mockServiceLoader);
		} catch (SecurityException e) {
			Assert.fail();
		}
		Assert.assertEquals(methodToTest, nonDefaultPlugin1);
	}
	
	@Test
	public void testIterate_moreThanOneNonDefault() {
		mockServiceLoader = PowerMockito.mock(ServiceLoader.class);
		
		CPService nonDefaultPlugin1 = PowerMockito.mock(CPService.class);
		Mockito.when(nonDefaultPlugin1.isDefault()).thenReturn(false);
		CPService nonDefaultPlugin2 = PowerMockito.mock(CPService.class);
		Mockito.when(nonDefaultPlugin2.isDefault()).thenReturn(false);

		List<CPService> mutableList = new ArrayList<>();
		mutableList.add(nonDefaultPlugin1);
		mutableList.add(nonDefaultPlugin2);
		
		List<CPService> immutableList = Collections.unmodifiableList(mutableList);
		
		Mockito.when(mockServiceLoader.iterator()).thenReturn(immutableList.iterator());
		CPService methodToTest = null;
		try {
			methodToTest = Reflection.method("iterate").withReturnType(CPService.class).withParameterTypes(ServiceLoader.class)
					.in(serviceLoaderDemo).invoke(mockServiceLoader);
		} catch (SecurityException e) {
			Assert.fail();
		}
		Assert.assertEquals(methodToTest, nonDefaultPlugin2);
	}
	
	@Test
	public void testIterate_oneDefaultmoreThanOneNonDefault() {
		mockServiceLoader = PowerMockito.mock(ServiceLoader.class);
		
		CPService defaultPlugin = PowerMockito.mock(CPService.class);
		Mockito.when(defaultPlugin.isDefault()).thenReturn(true);
		CPService nonDefaultPlugin1 = PowerMockito.mock(CPService.class);
		Mockito.when(nonDefaultPlugin1.isDefault()).thenReturn(false);
		CPService nonDefaultPlugin2 = PowerMockito.mock(CPService.class);
		Mockito.when(nonDefaultPlugin2.isDefault()).thenReturn(false);

		List<CPService> mutableList = new ArrayList<>();
		mutableList.add(defaultPlugin);
		mutableList.add(nonDefaultPlugin1);
		mutableList.add(nonDefaultPlugin2);
		
		List<CPService> immutableList = Collections.unmodifiableList(mutableList);
		
		Mockito.when(mockServiceLoader.iterator()).thenReturn(immutableList.iterator());
		CPService methodToTest = null;
		try {
			methodToTest = Reflection.method("iterate").withReturnType(CPService.class).withParameterTypes(ServiceLoader.class)
					.in(serviceLoaderDemo).invoke(mockServiceLoader);
		} catch (SecurityException e) {
			Assert.fail();
		}
		Assert.assertEquals(methodToTest, nonDefaultPlugin2);
	}
	
	@Test
	public void testIterate_oneDefaultAndOneNonDefault() {
		mockServiceLoader = PowerMockito.mock(ServiceLoader.class);
		
		CPService defaultPlugin = PowerMockito.mock(CPService.class);
		Mockito.when(defaultPlugin.isDefault()).thenReturn(true);
		CPService nonDefaultPlugin1 = PowerMockito.mock(CPService.class);
		Mockito.when(nonDefaultPlugin1.isDefault()).thenReturn(false);

		List<CPService> mutableList = new ArrayList<>();
		mutableList.add(defaultPlugin);
		mutableList.add(nonDefaultPlugin1);
		
		List<CPService> immutableList = Collections.unmodifiableList(mutableList);
		
		Mockito.when(mockServiceLoader.iterator()).thenReturn(immutableList.iterator());
		CPService methodToTest = null;
		try {
			methodToTest = Reflection.method("iterate").withReturnType(CPService.class).withParameterTypes(ServiceLoader.class)
					.in(serviceLoaderDemo).invoke(mockServiceLoader);
		} catch (SecurityException e) {
			Assert.fail();
		}
		Assert.assertEquals(methodToTest, nonDefaultPlugin1);
	}
}