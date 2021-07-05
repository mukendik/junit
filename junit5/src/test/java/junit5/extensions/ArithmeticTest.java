package junit5.extensions;

import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import junit5.aut.Calculate;
import junit5.extensions.exceptionhandling.DevideExceptionHandler;
import junit5.extensions.testinstancepostprocessing.LoggingPostProcessExtension;
import junit5.extensions.testinstancepredestroy.*;

public class ArithmeticTest {
		
		private int result = 5;
		private Logger logger;
	  
	  @Test
	  void test_Add() {
	    result = Calculate.add(result, 5);
	    System.out.println("test_Add(5,5) => "+ result);
	    Assertions.assertEquals(10, result);
	  }
	  
	 
	  @ExtendWith(DisplayPredestroyedInstances.class)
	  @Test
	  void test_Multiply() {
	    result = Calculate.multiple(result, 5);
	    System.out.println("test_Multiply(5,5) => "+ result);
	    Assertions.assertEquals(25, result);
	  }
	  @ExtendWith(LoggingPostProcessExtension.class)
	  @Test
	  void test_Devide() {
	    result = Calculate.devide(result, 5);
	    System.out.println("test_Devide(5,5) => "+ result);
	    Assertions.assertEquals(1, result);
	  }  
	  
	  @ExtendWith(DevideExceptionHandler.class)
	  @Test
	  void test_Devide_by_zero() {
	    result = Calculate.devide(result, 0);
	    System.out.println("test_Devide_by_zero(5,0) => "+ result);
	  //  assertEquals(1, result);
	  }  
	  
	  public void createLogger(Logger logger) {
		  this.logger = logger;
	  }
}
