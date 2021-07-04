package junit5.extensions.conditionaltestexecution;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

public class EnvironmentVariableConditionalTest {
    @Disabled
    @Test
    void printSystemProperties() {
      // Remove @Disabled to see environment properties
      System.getenv().forEach((key, value) -> System.out.println(key+" - "+value));
    }
    @Test
    @EnabledIfEnvironmentVariable(named = "COMPUTERNAME", matches = "sysname")
    void runOnlyOnPerticularMachine() {
      System.out.println("Run this only on particular server");
    }
    @Test
    @DisabledIfEnvironmentVariable(named = "PROCESSOR_ARCHITECTURE", matches = ".*32.*")
    void noRrunOn32bitOS() {
      System.out.println("Not run this on 32 bit OS");
    }
    
    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "username")
    void runOnlyForParticularUser() {
      System.out.println("run this only for particular user in system");
    }
}

