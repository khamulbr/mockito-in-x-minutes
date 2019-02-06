package com.in28minutes.mockito.mockitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class SomeBusinessMockTest {

	@Test
	public void testFindGreatestFromAllData() {
		DataService dataServiceMock = mock(DataService.class);
	
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24 ,6 ,15});
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findGreatestFromAllData();
		assertEquals(24, result);
	}
	
	@Test
	public void testFindGreatestFromAllData_ForOneValue() {
		DataService dataServiceMock = mock(DataService.class);
	
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
		int result = businessImpl.findGreatestFromAllData();
		assertEquals(15, result);
	}



}
