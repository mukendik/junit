package junit5.extensions.seleniumjupiter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.grid.selenium.GridLauncherV3;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.seljup.DriverCapabilities;
import io.github.bonigarcia.seljup.DriverUrl;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;


@ExtendWith(SeleniumJupiter.class)
public class RemoteBrowserJupiterTest {
	 	@DriverUrl
	    String url = "http://localhost:4444/wd/hub";

	   // @DriverCapabilities
	   // Capabilities capabilities = firefox();

	    @BeforeAll
	    static void setup() throws Exception {
	        // Start hub
	        GridLauncherV3.main(new String[] { "-role", "hub", "-port", "4444" });

	        // Register Chrome in hub
	        WebDriverManager.chromedriver().setup();
	        GridLauncherV3.main(new String[] { "-role", "node", "-hub",
	                "http://localhost:4444/grid/register", "-browser",
	                "browserName=chrome", "-port", "5555" });

	        // Register Firefox in hub
	        WebDriverManager.firefoxdriver().setup();
	        GridLauncherV3.main(new String[] { "-role", "node", "-hub",
	                "http://localhost:4444/grid/register", "-browser",
	                "browserName=firefox", "-port", "5556" });
	    }

		@Test
	    void testWithRemoteChrome(
	            @DriverUrl("http://localhost:4444/wd/hub")
	            @DriverCapabilities("browserName=chrome") RemoteWebDriver driver) {
	        exercise(driver);
	    }

	    @Test
	    void testWithRemoteFirefox(
	    		 	@DriverUrl("http://localhost:4444/wd/hub")
		            @DriverCapabilities("browserName=firefox") RemoteWebDriver driver) {
	        exercise(driver);
	    }

	    void exercise(WebDriver driver) {
	        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
	        Assertions.assertEquals(driver.getTitle(),
	                "Selenium-Jupiter: JUnit 5 extension for Selenium");
	    }
}
