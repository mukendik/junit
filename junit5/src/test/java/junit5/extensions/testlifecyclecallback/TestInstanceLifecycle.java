package junit5.extensions.testlifecyclecallback;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestInstanceLifecycle {

	public TestInstanceLifecycle() {
		super();
		System.out.println("test instance Constructor");
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeAll : Before the entire test fixture");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		 System.out.println("@AfterAll : After the entire test fixture");
	}

	@BeforeEach
	void setUp() throws Exception {
		 System.out.println("@BeforeEach : Before each test");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("@AfterEach : After each test");
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
