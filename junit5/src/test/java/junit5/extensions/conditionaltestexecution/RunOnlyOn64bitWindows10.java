package junit5.extensions.conditionaltestexecution;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnOs;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Test
@EnabledOnOs({ OS.WINDOWS })
@EnabledIfSystemProperty(named = "os.version", matches = ".*10.*")
@EnabledIfEnvironmentVariable(named = "PROCESSOR_ARCHITECTURE", matches = ".*64.*")
public @interface RunOnlyOn64bitWindows10 {

}
