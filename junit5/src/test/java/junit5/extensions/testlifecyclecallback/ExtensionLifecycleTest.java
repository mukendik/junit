package junit5.extensions.testlifecyclecallback;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ExtensionCallbackLifecycle.class)
public class ExtensionLifecycleTest {
	
	@BeforeEach
	void beforeEachTest() {
	    System.out.println("Before each test");
	 }

	@AfterEach
	void afterEachTest() {
	    System.out.println("After each test");
	 }

    @Test
    void firstTest() {
        System.out.println("First test");
    }

    @Test
    void secondTest() {
        System.out.println("Second test");
    }
}
