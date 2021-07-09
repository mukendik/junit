package junit5.extensions.testinstancefactory;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(CustomTestInstanceFactory.class)
public class Outer  {

	@Test
	void outer() {
	}

	@Nested
	// @ExtendWith(CustomTestInstanceFactory.class)
	class Inner {

		@Test
		void inner() {
		}

		@Nested
		// @ExtendWith(CustomTestInstanceFactory.class)
		class InnerInner {

			@Test
			void innerInner() {
			}

		}
	}
}
