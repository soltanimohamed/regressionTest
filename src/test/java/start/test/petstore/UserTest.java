package start.test.petstore;

import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UserTest extends BaseUtil{
	
	public String userUrl = "http://localhost:8080/api/user/";
	
	@Before
	public void setup() {
		init();
		JSONObject userBody = jsonUserBody(100, "Test100", "Test", "Testing", "test@testing.com", "123456", "987654", 1);
		post(userBody, userUrl);
	}

	@Test
	public void getUser() {
		getUser("Test100", "Test", userUrl);
	}
	
	
	@Test
	public void updateUser() {
		JSONObject userBody = jsonUserBody(100, "Test100", "Test1", "Testing1", "test1@testing.com", "123456", "987654", 1);
		put("Test100", userBody, userUrl);
		getUser("Test100", "Test1", userUrl);
	}
	

	
	@After
	public void delete() {
		deleteUser("Test100", userUrl);
	}

}
