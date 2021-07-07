package junit5.extensions.registeringextensions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import junit5.aut.Calculate;
import junit5.extensions.exceptionhandling.DevideExceptionHandler;

// 1. For Test Class
@ExtendWith(LoggingExtension.class)
// 2. Composed Annotation
@ExtendWith({LoggingExtension.class, DevideExceptionHandler.class})
public class RegisteringExtensionTest {
	
	// 3. For Test Method
	@ExtendWith(DevideExceptionHandler.class)
	@Test
	void devidetestmethod() {
		Calculate.devide(5, 0);
	}
	@ExtendWith(LoggingExtension.class)
	@Test
	void devidemethod() {
		Calculate.devide(0, 0);
	}
}
