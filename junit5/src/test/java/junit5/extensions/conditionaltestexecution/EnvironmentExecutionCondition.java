package junit5.extensions.conditionaltestexecution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.platform.commons.support.AnnotationSupport;


public class EnvironmentExecutionCondition implements ExecutionCondition{

	@Override
	public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext context) {
	
			String activeEnvironment = System.getProperty("environment");
			if(activeEnvironment == null) {
				return ConditionEvaluationResult.disabled("There is no active environment");
			}
			Set<String> enabledEnvironments = getEnabledEnvironment(context);
			return enabledEnvironments.contains(activeEnvironment)
				? ConditionEvaluationResult.enabled("active environment is  enabled")
				: ConditionEvaluationResult.disabled("active environment is not enabled");
		}

		private Set<String> getEnabledEnvironment(ExtensionContext context) {
			Set<String> enabledEnvironments = new HashSet<>();
			context.getElement().ifPresent(element -> AnnotationSupport.findAnnotation(element, Environment.class)
					.map(Environment::enabledFor)
					.ifPresent(array -> enabledEnvironments.addAll(Arrays.asList(array)))
					);
			return enabledEnvironments;
		}

}
