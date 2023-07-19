package egovframework.noteTranslate.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiProfileAccess {
	


	    private String token;
	    private String header;
	    private String apiUrl;
	    
	    


	    public ApiProfileAccess(String token, String header, String apiUrl) {
			this.token = token;
			this.header = header;
			this.apiUrl = apiUrl;
		}


		public Map<String, Object> get(Map<String, String> requestHeaders){
			HttpURLConnection con = connect(apiUrl);
	        JSONObject jsonObjt;
	        Map<String, Object> map;
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }


	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                jsonObjt = new JSONObject(readBody(con.getInputStream()));
	                JSONObject response = jsonObjt.getJSONObject("response");
	                map = new HashMap<>(response.toMap());
	                return map;
	            } else { // 에러 발생
	                jsonObjt =  new JSONObject(readBody(con.getErrorStream()));
	                map = new HashMap<>(jsonObjt.toMap());
	                return map;
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }
		
		public Map<String, Object> getResponseByKakao(Map<String, String> requestHeaders){
			HttpURLConnection con = connect(apiUrl);
	        JSONObject jsonObjt;
	        Map<String, Object> map;
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }


	            int responseCode = con.getResponseCode();
	            
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	            	String jsonParam = readBody(con.getInputStream());
	            	System.out.println("set the json object");
	                jsonObjt = new JSONObject(jsonParam);
	                System.out.println("pass json");
	                JSONObject response = jsonObjt.getJSONObject("properties");
	                map = new HashMap<>(response.toMap());
	                return map;
	            } else { // 에러 발생
	                jsonObjt =  new JSONObject(readBody(con.getErrorStream()));
	                map = new HashMap<>(jsonObjt.toMap());
	                return map;
	            }
	        } catch (IOException e) {
	        	e.printStackTrace();
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } catch(JSONException e) {
	        	e.printStackTrace();
	        	throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }


	    private static HttpURLConnection connect(String apiUrl){
	        try {
	        	System.out.println("connect");
	            URL url = new URL(apiUrl);
	            System.out.println("url constructor");
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	        	e.printStackTrace();
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	        	e.printStackTrace();
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }


	    private static String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);


	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();


	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }


	            return responseBody.toString();
	        } catch (IOException e) {
	        	e.printStackTrace();
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }
	
}
