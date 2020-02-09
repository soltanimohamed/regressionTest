package start.test.petstore;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PetTest extends BaseUtil{
	
	public String petUrl = "http://localhost:8080/api/pet/";
	public String storeUrl = "http://localhost:8080/api/store/order";
	
	@Before
	public void setup() {
		init();
		JSONObject petBody = jsonPetBody(20, 1, "pet", "Labrador", "",1 ,"", "available");
		post(petBody, petUrl);
		
	}
	
	@After
	public void clear() {
		deletePet(20, petUrl);
	}
	

	
	@Test
	public void get() {
		getPet(20, "Labrador", petUrl);
	}

	@Test
	public void put() {
		JSONObject petBody = jsonPetBody(20, 1, "pet", "Labrador Retreiver", "",1 ,"", "available");
		put(petBody, petUrl);
		getPet(20, "Labrador Retreiver", petUrl);
	}
	
	
	
	@Test
	public void postorder() {
		postOrder(109,20,30,"2019-12-15T09:01:47.750+0000","placed",false, storeUrl);
	}
	
}
