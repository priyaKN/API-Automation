import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by C842045 on 1/12/2019.
 */
public class TestLoginApi extends BaseTest {
    @Test
    public void loginApiTest() throws IOException {
        TestPlanReader          d    = new TestPlanReader();
        ArrayList               data = d.getData("Invalid Login", "Valid Login");
        HashMap<String, Object> map  = new HashMap<String, Object>();
        map.put("username", data.get(1));
        map.put("password", data.get(2));
        RestAssured.baseURI = prop.getProperty("HOST");
        given().
                header("Content-Type", "application/json").
                body(map).
                when().
                post("url").
                then().assertThat().statusCode(200).and().body("message", equalTo("Invalid Username or Password"));
    }
}
