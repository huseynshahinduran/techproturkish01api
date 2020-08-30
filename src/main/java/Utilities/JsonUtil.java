package Utilities;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	private static ObjectMapper mapper;
	
	static {
		mapper=new ObjectMapper();
	}
	
	//Java object'ini Json formatina cevir method ==> Serialization
	public static String convertJavaJson(Object object) {
		
		String jsonResult="";
		try {
			jsonResult=mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}
	
	//Josn formatindan 
	public static <T> T convertJsonToJava(String json, Class<T>cls) {
		
		T javaResult=null;
		
		try {
			javaResult=mapper.readValue(json, cls);
		} catch (JsonParseException e) {
			System.out.println("Json'i Java'ya cevirirken Exception olustu"+e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("Json'i Java'ya cevirirken Exception olustu"+e.getMessage());
		} catch (IOException e) {
			System.out.println("Json'i Java'ya cevirirken Exception olustu"+e.getMessage());
		}
		
		return javaResult;
		
	}
	
}
