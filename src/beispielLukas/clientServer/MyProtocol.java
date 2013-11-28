package beispielLukas.clientServer;

public class MyProtocol {

    public String processInput(String input) {
    	
    	if(input != null){
    		String reverse = new StringBuilder(input).reverse().toString();
    		return reverse;
    	}
    	else{
    		return "hellou";
    	}
    }
}