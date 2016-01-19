package me.itnotes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* Este programa:
* Carga el contexto(ApplicationContext) definido en el XML application-context.xml
* Obtiene el bean messageBean, declarado en el xml.
* Llama a Message.printMessage, que imprime en consola el mensaje que tiene el bean.
*
* Es un ejempo muy sencillo que muestra cómo es lo definido en el xml quien controla la creación y manejo de dependencias entre objetos.
*
* Hay algunas trazas que ayudan a seguir la ejecución. 
* El bucle for lista los beans declarados en el application-context.xml
* En este caso sólo hay uno, pero lo habitual es uqe haya varios.
* Todo lo que se hace declarando en un XML, se puede hacer por código o con anotaciones. El control es total.
* @author  Rafa Soriazu
* @version 1.0
*/
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