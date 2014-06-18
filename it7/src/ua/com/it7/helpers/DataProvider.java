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

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataProvider extends DefaultHttpClient {
	static final String	URL	= "http://it7.com.ua/test/people.json";
	
	public DataProvider() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Person> boo() {
		ObjectMapper mapper = new ObjectMapper();
		String s = null;
		
		try {
			HttpGet getRequest = new HttpGet(URL);
			HttpResponse getResponse = this.execute(getRequest);
			final int statusCode = getResponse.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				s = null;
			}
			HttpEntity getResponseEntity = getResponse.getEntity();
			if (getResponseEntity != null) {
				s = EntityUtils.toString(getResponseEntity, HTTP.UTF_8);
			}
			
			JSONObject people = new JSONObject(s);
			Iterator<String> keys = people.keys();
			ArrayList<Person> morePeople = new ArrayList<Person>();
			JSONObject p = null;
			while (keys.hasNext()) {
				p = people.getJSONObject(keys.next());
				morePeople.add(mapper.readValue(p.toString(), Person.class));
			}
			return morePeople;
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Person>();
	}
}
