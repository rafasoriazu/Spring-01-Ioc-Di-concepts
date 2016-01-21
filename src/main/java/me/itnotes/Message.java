package me.itnotes;


/**
* Bean Message
* 
* @author  Rafa Soriazu
*
*/
public class Message {

  private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void processMessage(){
     message=" Este es el mensaje que tengo: " +message;
   }
}