package junit5.extensions.conditionaltestexecution;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import junit5.aut.Calculate;

public class EnvironmentConditionalTest {

    @Test
    @Environment(enabledFor = {"Dev", "QA"})
    void add() {
        Assertions.assertEquals(2, Calculate.add(1, 1));
    }
    @Test
    void multiply() {
        Assertions.assertEquals(6, Calculate.multiple(3, 2));
    }

}
