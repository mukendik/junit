package junit5.extensions.testinstancepostprocessing;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePostProcessor;

public class LoggingPostProcessExtension implements TestInstancePostProcessor{

	@Override
	public void postProcessTestInstance(Object testInstance, ExtensionContext context) throws Exception {

		Logger logger = LogManager.getLogger(testInstance.getClass()
														 .getName());
		System.out.println("Test instance Post-Process Extension called on :"+ testInstance.getClass().getName());
		
        testInstance.getClass()
          .getMethod("createLogger", Logger.class)
          .invoke(testInstance, logger); 		
	  }  
}
