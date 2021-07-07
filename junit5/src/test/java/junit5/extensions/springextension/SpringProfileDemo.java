package junit5.extensions.springextension;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import junit5.*;

public class SpringProfileDemo {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.concretepage");
		ctx.refresh();
		MyService myService = ctx.getBean(MyService.class);
		System.out.println(myService.getMessage());	

	}

}
