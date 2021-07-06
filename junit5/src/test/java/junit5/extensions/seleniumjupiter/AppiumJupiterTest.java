package junit5.extensions.seleniumjupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumJupiter;

@ExtendWith(SeleniumJupiter.class)
public class AppiumJupiterTest {
		@DriverUrl
	    String url = "http://localhost:4723/wd/hub";

	    @DriverCapabilities
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    {
	        capabilities.setCapability("browserName", "chrome");
	        capabilities.setCapability("deviceName", "Samsung Galaxy S6");
	    }

	    @Test
	    void testWithAndroid(AppiumDriver<WebElement> driver) {
	        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
	        Assertions.assertEquals(driver.getTitle(),
	                "JUnit 5 extension for Selenium");
	    }
}
