package JavaBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class test {

	public static void main(String[] args) {
		ApplicationContext actx = new FileSystemXmlApplicationContext("WebContent/WEB-INF/config.xml");
		helloworld h = (helloworld) actx.getBean("HelloWorld");
		System.out.println(h.getMsg());
	}

}
