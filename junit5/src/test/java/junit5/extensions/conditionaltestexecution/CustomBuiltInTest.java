package junit5.extensions.conditionaltestexecution;

public class CustomBuiltInTest {
    @RunOnlyOn64bitWindows10
    void runOnlyOn64bitWindows10() {
        System.out.println("Run only this on 64 bit Windows 10 System.");
      }

}
