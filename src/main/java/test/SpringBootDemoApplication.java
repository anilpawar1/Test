package test;

import java.util.Arrays;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
 
@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner {
 
	@Autowired
	DataSource dataSource;
   public static void main(String[] args){
	   
	   ApplicationContext ctx = SpringApplication.run(SpringBootDemoApplication.class, args);
 
       String[] beanNames = ctx.getBeanDefinitionNames();
         
       Arrays.sort(beanNames);
        
       for (String beanName : beanNames){
           System.out.println(beanName);
       }
   }

public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	System.out.println("########## DATASOURCE = ");
	
	/*LogManager.getLogger().info("Starting GT Microservices...");
	if(args.length == 0){
		AppContext.newInstance(null);
	} else {
		AppContext.newInstance(args[0].trim());
	}*/
}
}