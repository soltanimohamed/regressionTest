package start.test.petstore;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

import java.time.OffsetDateTime;

public class BaseUtil {
	
	public  RequestSpecification request;
	public  Response response;
	public List<String> listPhotos = 	new ArrayList<String>();
	public List<JSONObject> listTags = 	new ArrayList<JSONObject>();
	public JsonPath jsonResponse;
	
	

	public void init() {
		request = RestAssured.given();
		request.header("accept", "application/json");
		request.header("Content-Type", "application/json");
	}
	
	public void getPet(int petId, String petName, String url) {
		response = request.get(url + petId);
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals(petName, response.jsonPath().getString("name"));
	}
	
	
   public  JSONObject jsonPetBody(int id, int category_ID, String category_Name, String pet_Name,String photos, int tags_ID, String tags_Name, String status){
		JSONObject petJsonBody =new JSONObject();
		JSONObject jsonCtaegory = new JSONObject();
		JSONObject jsonTags = new JSONObject();
		petJsonBody.put("id", id);
		jsonCtaegory.put("id", category_ID);
		jsonCtaegory.put("name", category_Name);
		petJsonBody.put("name", pet_Name);
		listPhotos.add(photos);
		petJsonBody.put("photoUrls",listPhotos);
		jsonTags.put("id", tags_ID);
		jsonTags.put("name", tags_Name);
		listTags.add(jsonTags);
		petJsonBody.put("status", "available");
		return petJsonBody;
	
	}
	
	
	
	public void post(JSONObject jsonBody, String url) {
		request.body(jsonBody.toString());
		response =  request.post(url);
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	
	public void put(JSONObject jsonBody, String url) {
		request.body(jsonBody.toString());
		response =  request.put(url);
		Assert.assertEquals(200, response.getStatusCode());
	}

	public void deletePet(int petId, String url) {
		response = request.delete(url + petId);
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	
	public void postOrder(int orderId, int pet_id, int quantity, String shippingDate, String status, boolean complete_status, String url) {
		JSONObject petJsonBody =new JSONObject();
		petJsonBody.put("id", orderId);
		petJsonBody.put("petId", pet_id);
		petJsonBody.put("quantity", quantity);
		petJsonBody.put("shipDate", shippingDate);
		petJsonBody.put("status", status);
		petJsonBody.put("complete", complete_status);
		request.body(petJsonBody.toString());
		response =  request.post(url);
		Assert.assertEquals(200, response.getStatusCode());
		
	}
	

	
	public JSONObject jsonUserBody(int user_id, String user_name, String first_name, String last_name, String user_email, String user_psw, String user_phone, int user_status){
		JSONObject userJsonBody =new JSONObject();
		userJsonBody.put("id", user_id);
		userJsonBody.put("username", user_name);
		userJsonBody.put("firstName",first_name) ;
		userJsonBody.put("lastName", last_name);
		userJsonBody.put("email", user_email);
		userJsonBody.put("password", user_psw);
		userJsonBody.put("phone", user_phone);
		userJsonBody.put("userStatus", user_status);
		return userJsonBody;
	
	}
	
	
	public void getUser(String user_name, String firstName, String url) {
		response = request.get(url + user_name);
		Assert.assertEquals(200, response.getStatusCode());
		Assert.assertEquals(firstName, response.jsonPath().getString("firstName"));
	}
	
	public void deleteUser(String user_name, String url) {
		response = request.delete(url + user_name);
		Assert.assertEquals(200, response.getStatusCode());
	}
	
	public void put(String userName, JSONObject jsonBody, String url) {
		request.body(jsonBody.toString());
		response =  request.put(url + userName);
		Assert.assertEquals(200, response.getStatusCode());
	}

	
}
