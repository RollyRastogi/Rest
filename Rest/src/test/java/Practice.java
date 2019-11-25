import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import java.util.ArrayList;

import org.testng.annotations.Test;
import com.jayway.restassured.*;
import com.jayway.restassured.path.json.JsonPath;

import groovy.json.JsonParser;
import groovy.json.JsonSlurper;

public class Practice {
	@Test
	public void sample() {
		String str=given()
			
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
		.then()
			.statusCode(200)
			//.body(containsString("\"userId\": 7"))
			.body("userId", hasItem(7))
			.extract().response().prettyPrint();
	
			JsonPath path=new JsonPath(str);
			ArrayList total = path.get("userId");
	
			for (int i=0;i<total.size();i++)
			{
				if (path.get("["+ i +"].userId").equals(7))
				{
					System.out.println((i +1)+"--"+ path.getString("["+ i +"].title"));
				}
			}

		/*
•	username
•	sessionid
•	sessionid[3]
•	students[1].marks
•	students[0].adresss[1].state
•	students[1].contact[1]
•	students[1].adresss[:0].city
•	students[1].adresss[:0].city
•	students[0].adresss
*/
		

}

}
