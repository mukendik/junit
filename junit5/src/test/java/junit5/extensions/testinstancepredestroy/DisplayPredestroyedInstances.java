package junit5.extensions.testinstancepredestroy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;
import org.junit.jupiter.api.extension.TestInstances;

public class DisplayPredestroyedInstances implements  TestInstancePreDestroyCallback{

	@Override
	public void preDestroyTestInstance(ExtensionContext context) throws Exception {
		List<Object> destroyedInstances = new ArrayList<>(context.getRequiredTestInstances().getAllInstances());
        for (Optional<ExtensionContext> current = context.getParent(); 
                current.isPresent(); 
                current = current.get().getParent()) {
            current.get().getTestInstances().map(TestInstances::getAllInstances).ifPresent(destroyedInstances::removeAll);
        }
        Collections.reverse(destroyedInstances);
        destroyedInstances.forEach(testInstance -> System.out.println("preDestroy: " + testInstance));
        System.out.println("preDestroy: " + context.getRequiredTestInstance());      
	}
}
