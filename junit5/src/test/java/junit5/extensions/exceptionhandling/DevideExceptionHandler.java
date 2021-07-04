package junit5.extensions.exceptionhandling;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class DevideExceptionHandler implements TestExecutionExceptionHandler{

	public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
		System.out.println("operation not allowed for division");
	}
}
