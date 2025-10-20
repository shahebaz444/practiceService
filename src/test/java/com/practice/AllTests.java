package com.practice;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectClasses({
	CalculatorTest.class,
	UtilTest.class
})
public class AllTests {

}
