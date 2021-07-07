package junit5.extensions.registeringextensions;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import com.gargoylesoftware.htmlunit.WebClient;

public class WebServerDemo {
	@RegisterExtension 
	static WebServerExtension server = WebServerExtension.builder()
										.enableSecurity(false) 
										.build();

	@Test 
	void getProductList() { 
	WebClient webClient = new WebClient();
	String serverUrl = server.getServerUrl();
	 // Use WebClient to connect to web server using serverUrl and verify response 
	assertEquals(200, webClient.get(serverUrl + "/products").getResponseStatus());
	 } 

}
