import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ceking.spring.config.MyAnnotaionConfiguration;
import com.ceking.spring.entity.Employee;

public class SpringTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyAnnotaionConfiguration.class);
		Employee bean = applicationContext.getBean(Employee.class);
		System.out.println(bean);	
		applicationContext.close();
	}
}