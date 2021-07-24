package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeadersConfig {
	
	public Map<String, String> defaultHeader(){
		Map<String, String> defaulHeader = new HashMap<String, String>();
		defaulHeader.put("Content-Type", "application/json");
		
		return defaulHeader;
	}
	
	public Map<String, String> headerswithToken(){
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		defaultHeaders.put("Access_Token","");
		defaultHeaders.put("jwt_Token","");
		defaultHeaders.put("Tenet_user","");
		
		return defaultHeaders;
	}
	
	public static void main(String[] args) {
		HeadersConfig header = new HeadersConfig();
		System.out.println(header.defaultHeader());
	}
}
