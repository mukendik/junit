package junit5.extensions.seleniumjupiter;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.startsWith;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.seljup.SeleniumJupiter;


@ExtendWith(SeleniumJupiter.class)
public class CrossBrowserTest {
	@Test
    void testWithOneChrome(ChromeDriver chromeDriver) {
        // Use Chrome in this test
		chromeDriver.get("https://bonigarcia.github.io/selenium-jupiter/");
        Assertions.assertEquals(chromeDriver.getTitle(),
                "Selenium-Jupiter: JUnit 5 extension for Selenium");
    }

    @Test
    void testWithFirefox(FirefoxDriver firefoxDriver) {
        // Use Firefox in this test
    	firefoxDriver.get("https://bonigarcia.github.io/selenium-jupiter/");
        Assertions.assertEquals(firefoxDriver.getTitle(),
        		"Selenium-Jupiter: JUnit 5 extension for Selenium");
    }

    @Test
    void testWithChromeAndFirefox(ChromeDriver chromeDriver,
            FirefoxDriver firefoxDriver) {
        // Use Chrome and Firefox in this test
    	chromeDriver.get("http://www.seleniumhq.org/");
    	firefoxDriver.get("http://junit.org/junit5/");
    	Assertions.assertEquals(chromeDriver.getTitle(), "SeleniumHQ Browser Automation");
    	Assertions.assertEquals(firefoxDriver.getTitle(), "JUnit 5");
    }

}
