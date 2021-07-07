package junit5.extensions.registeringextensions;

import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import com.beust.jcommander.JCommander.Builder;

public class WebServerExtension implements BeforeAllCallback{
	
    private final boolean securityEnabled;
    private final String serverUrl;

    
	public WebServerExtension(Builder builder) {
		super();
		this.securityEnabled = builder.securityEnabled;
		this.serverUrl = builder.serverUrl;
	}

	@Override
	public void beforeAll(ExtensionContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean isSecurityEnabled() {
		return securityEnabled;
	}

	public String getServerUrl() {
		return serverUrl;
	}

	 public static Builder builder() {
	        return new Builder();
	      }

	      public static class Builder {
	        private boolean enableSecurity;
	        private String serverUrl;
	        public Builder enableSecurity(boolean b) {
	          this.enableSecurity = b;
	          return this;
	        }
	        public Builder serverUrl(String url) {
	          this.serverUrl = url;
	          return this;
	        }
	        public WebServerExtension build() {
	          return new WebServerExtension(this);
	        }
	      }
}
