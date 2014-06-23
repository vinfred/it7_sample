package ua.com.it7.helpers;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import ua.com.it7.model.Person;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProvider extends DefaultHttpClient {
	static final String	URL_PEOPLE	= "http://it7.com.ua/test/people.json";
	// static final String URL_PEOPLE = "http://pravda.com.ua/";
	static final String	URL_IMG		= "http://it7.com.ua/test/img.json";
	
	public DataProvider() {
		super();
	}
	
	public ArrayList<String> getImage() {
		String s = readJson(URL_IMG);
		Log.i("getimage", "oioi");
		try {
			JSONObject obj = new JSONObject(s);
			Iterator<?> keys = obj.keys();
			ArrayList<String> imgs = new ArrayList<>();
			
			while (keys.hasNext()) {
				imgs.add(obj.getString((String) keys.next()));
			}
			Log.i("getimage", imgs.toString());
			return imgs;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String readJson(String url) {
		String s = null;
		
		HttpGet getRequest = new HttpGet(url);
		HttpResponse getResponse;
		try {
			getResponse = this.execute(getRequest);
			final int statusCode = getResponse.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				s = null;
			}
			HttpEntity getResponseEntity = getResponse.getEntity();
			if (getResponseEntity != null) {
				s = EntityUtils.toString(getResponseEntity, HTTP.UTF_8);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	public ArrayList<Person> boo() {
		ObjectMapper mapper = new ObjectMapper();
		String s = readJson(URL_PEOPLE);
		
		try {
			JSONObject people = new JSONObject(s);
			Iterator<?> keys = people.keys();
			ArrayList<Person> morePeople = new ArrayList<>();
			JSONObject p = null;
			while (keys.hasNext()) {
				p = people.getJSONObject((String) keys.next());
				morePeople.add(mapper.readValue(p.toString(), Person.class));
			}
			return morePeople;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
