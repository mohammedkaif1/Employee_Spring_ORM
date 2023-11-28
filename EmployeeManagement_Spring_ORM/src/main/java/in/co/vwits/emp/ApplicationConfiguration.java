package in.co.vwits.emp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
@Configuration
@ComponentScan(basePackages="in.co.vwits.emp")
@EnableTransactionManagement
public class ApplicationConfiguration {
	@Bean
	   public LocalEntityManagerFactoryBean get()
	   {    
		   
		   LocalEntityManagerFactoryBean factory=new LocalEntityManagerFactoryBean();
		   factory.setPersistenceUnitName("empapp");
		   return factory;
	   }
		//Following bean is responsible for managing transactions using spring framework
		@Bean
		public AbstractPlatformTransactionManager transactionManager()
		{
			JpaTransactionManager tx=new JpaTransactionManager();
			tx.setEntityManagerFactory(get().getObject());
			return tx;
		}

}
