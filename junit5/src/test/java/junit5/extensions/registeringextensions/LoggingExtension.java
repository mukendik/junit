package junit5.extensions.registeringextensions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class LoggingExtension implements TestExecutionExceptionHandler{

	public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
		
		System.out.println("========================================================\n"+
                "Hey, there seems to be something wrong with your test because :\n" + 
                throwable.getMessage());
			throw throwable;  
		
	}

}
