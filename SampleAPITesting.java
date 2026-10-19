import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleAPITesting {
	public static RequestSpecification resp;
	public static int expectedstatuscode=0;
	@BeforeTest
	public static
	void auth()
	{

		resp=given().baseUri("http://app.simpragma.ml").basePath("/linkapi/v1/visualivr").header("API-Key","65553183-4dff-42ee-ad2b-4edd15b38113").contentType(ContentType.XML).accept(ContentType.XML);
		
	}
	
	
	@Test
	public void m1()
	{
		Response response=	resp.when().queryParam("7975067198", "1234567899").post();
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		Assert.assertTrue(response.getStatusCode()==200);
		Assert.assertTrue(response.getStatusLine()=="HTTP/1.1 200 OK");
	}
	
}
