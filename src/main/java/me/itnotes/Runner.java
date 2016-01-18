package me.itnotes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Runner {

	public static void main(String[] args) {
		System.out.println("Inicio");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");   
	   System.out.println("Contexto inicializado");
	   System.out.println("Lista de beans:");
	   for (String aux:applicationContext.getBeanDefinitionNames()){
	    	 System.out.println("- "+aux);
	   }
      Message message = (Message) applicationContext.getBean("messageBean");
         message.printMessage();
         ((ConfigurableApplicationContext)applicationContext).close();
         
	}

}