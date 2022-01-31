import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTest extends RequestSpec {

    @Before
    public void initTest() {
        RestAssured.requestSpecification = requestSpec;
    }

    @Test()
    public void testCreateSimpleUser() {
        Map<String, Object> jsonBodyUsingMap = new HashMap<>();
        jsonBodyUsingMap.put("id", 0);
        jsonBodyUsingMap.put("username", "username1");
        jsonBodyUsingMap.put("firstName", "userFirstName1");
        jsonBodyUsingMap.put("lastName", "userLastName");
        jsonBodyUsingMap.put("email", "email1@email.com");
        jsonBodyUsingMap.put("password", "pass1");
        jsonBodyUsingMap.put("phone", "8800800111");
        jsonBodyUsingMap.put("userStatus", 0);

        Response response = given()
                .body(jsonBodyUsingMap)
                .when()
                .post(EndPoints.createUser)
                .then()
                .assertThat()
                .body("message", equalTo("9223372036854775807"))
                .statusCode(200)
                .extract()
                .response();
        response.getBody().print();
    }

    @Test()
    public void testCreateUserJsonSchema() {
       Map<String, Object> jsonBodyUsingMap = new HashMap<>();
        jsonBodyUsingMap.put("id", 0);
        jsonBodyUsingMap.put("username", "username2");
        jsonBodyUsingMap.put("firstName", "userFirstName2");
        jsonBodyUsingMap.put("lastName", "userLastName2");
        jsonBodyUsingMap.put("email", "email2@email.com");
        jsonBodyUsingMap.put("password", "pass2");
        jsonBodyUsingMap.put("phone", "8800800222");
        jsonBodyUsingMap.put("userStatus", 0);

        RestAssured.given()
                .body(jsonBodyUsingMap)
                .when()
                .post(EndPoints.createUser)
                .then()
                .assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("create_user_response.json"));
    }
}