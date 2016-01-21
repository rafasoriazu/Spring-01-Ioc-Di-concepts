package me.itnotes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
* Este programa:
* Carga el contexto(ApplicationContext) definido en el XML application-context.xml
* Obtiene el bean messageBean, declarado en el xml.
* Llama a Message.processMessage, que hace algo en el mensaje.
* Obtiene el mensaje y lo imprime por consola.
*
* Es un ejempo muy sencillo que muestra cómo es lo definido en el xml quien controla la creación y manejo de dependencias entre objetos.
*
* Hay algunas trazas que ayudan a seguir la ejecución. 
* El bucle for lista los beans declarados en el application-context.xml
* En este caso sólo hay uno, pero lo habitual es uqe haya varios.
* Todo lo que se hace declarando en un XML, se puede hacer por código o con anotaciones. El control es total.
* Al final es recomendable cerrar el applicationContext
*
* @author  Rafa Soriazu
* @version 1.0
*/
public class Runner {

	public static void main(String[] args) {
		System.out.println("Inicio");
     //Creamos el applicationContext con lo definido en application-context.xml
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/application-context.xml");   
	   System.out.println("Contexto inicializado");
	   System.out.println("Lista de beans:");
	   for (String aux:applicationContext.getBeanDefinitionNames()){
	    	 System.out.println("- "+aux);
	   }
     //Obtenemo el bean que se nos ha creado
      Message message = (Message) applicationContext.getBean("messageBean");
     //LLamada a un metodo tonoto del bean
      message.processMessage();
     	System.out.println(message.getMessage());
     //Cerrar el applicationContext
      ((ConfigurableApplicationContext)applicationContext).close();
         
	}

}