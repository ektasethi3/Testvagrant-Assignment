package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Environment {

	public static Map<String, String> environment = new HashMap<String, String>();
	public static Properties prop = new Properties();

	public static Map<String, String> getEnv(){
		String env = System.getProperty("env");

		try {
			if(env.equalsIgnoreCase("qa")) {
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/Inputs/qa.properties");
				prop.load(fis);
				environment.put("ServerUrl", prop.getProperty("ServerUrl"));
				environment.put("APIkey", prop.getProperty("APIkey"));
				//environment.put("port", prop.getProperty("port"));
				//environment.put("username", prop.getProperty("username"));
				//environment.put("password", prop.getProperty("password"));
			}
			else if (env.equalsIgnoreCase("dev")) {
				FileInputStream fisdev = new FileInputStream(System.getProperty("user.dir")+"/Inputs/dev.properties");
				prop.load(fisdev);
				environment.put("DevUrl", prop.getProperty("DevUrl"));
				environment.put("port", prop.getProperty("port"));
				environment.put("username", prop.getProperty("username"));
				environment.put("password", prop.getProperty("password"));

			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return environment;
	}

	public static Map<String, String> getConfigreader(){
		if(environment==null) {
			environment = getEnv();
		}
		return environment;
	}


}
