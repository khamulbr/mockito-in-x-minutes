package com.in28minutes.mockito.mockitodemo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationsTest {

	@Mock
	DataService dataServiceMock;
	
	@InjectMocks
	SomeBusinessImpl businessImpl;
	
	@Test
	public void testFindGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {24 ,6 ,15});
		assertEquals(24, businessImpl.findGreatestFromAllData());
	}
	
	@Test
	public void testFindGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {15});
		assertEquals(15, businessImpl.findGreatestFromAllData());
	}
	
	@Test
	public void testFindGreatestFromAllData_NoValues() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findGreatestFromAllData());
	}

}
