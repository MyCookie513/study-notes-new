package web.Servlet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import web.Servlet.Service.AcountService;








@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:web/Servlet/applicationContext.xml")
public class test {

	@Autowired()
	@Qualifier("AcountServiceID")
	private AcountService acountservice;
	
	@Test()
	public void demo() {
		acountservice.transfer_acount("jason","cookie", 100);
	}
}
