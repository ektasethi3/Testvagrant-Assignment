package apiVerifications;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReport;

import java.io.IOException;
import java.util.Map;

public class APIVerification extends ExtentReport{

	public static void responseCodeValidation(Response resp, int statuscode) {
		try {
			Assert.assertEquals(statuscode, resp.getStatusCode());
			test.log(LogStatus.PASS, "Validated the status code "+resp.getStatusCode());
		}
		catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Getting the status code "+resp.getStatusCode()+" and my expected status code is "+statuscode);
		}
		catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	public static void getKeyValue(Response resp, String key,String expectedValue) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> data = mapper.readValue(resp.asString(), new TypeReference<Map<String, Object>>() {
		});


//		Map<String, Object> innerMap = (Map) data.get(key);



		Map<String, String> map =mapper.readValue(resp.asString(), Map.class);
		Assert.assertEquals(map.get("cod"),expectedValue);
	}

	public static void responseKeyValidation(Response resp, String key) {
		try {
			JSONArray array = new JSONArray(resp.getBody().asString());
			for(int i=0;i<array.length();i++) {
				JSONObject obj = array.getJSONObject(i);
				test.log(LogStatus.PASS, "Validate value is "+obj.getString(key));		
			}
		}
		catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

	public static void responseTimeVerification(Response resp) {
		try {
			long time = resp.time();
			test.log(LogStatus.INFO, "Time taken "+time);
		}
		catch (Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
}
