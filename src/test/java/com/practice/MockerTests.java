package com.practice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockerTests {
    @Mock
    private List<String> mockedList;

    @InjectMocks
    private MyClass myClass;
	
	
	
	@Test
	void method() {
		List<String> list = new ArrayList<>();
		List<String> spyList = spy(list);

		spyList.add("Hello");
		spyList.add("World");

		verify(spyList).add("Hello");
		assertEquals(2, spyList.size());
	}
	
    @Test
    void test() {
        when(mockedList.size()).thenReturn(10);
        assertEquals(10, mockedList.size());
    }

}
