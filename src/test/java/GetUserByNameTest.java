import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GetUserByNameTest extends RequestSpec {
    private String username = "username18";

    @Before
    public void initTest() {
        RestAssured.requestSpecification = requestSpec;
    }

    @Test()
    public void testCreateSimpleUser() {
        Map<String, Object> jsonBodyUsingMap = new HashMap<>();
        jsonBodyUsingMap.put("id", 128);
        jsonBodyUsingMap.put("username", username);
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
                .statusCode(200)
                .extract()
                .response();
        response.getBody().print();
    }

    @Test()
    public void testGetUserByName() {
        Response response = given()
                .when()
                .get(EndPoints.getUserByName + username)
                .then()
                .assertThat()
                .body("username", equalTo(username))
                .statusCode(200)
                .extract()
                .response();
        response.getBody().print();
    }

    @Test()
    public void testGetUserByWrongName() {
        Response response = given()
                .when()
                .get(EndPoints.getUserByName + "username")
                .then()
                .assertThat()
                .statusCode(404)
                .extract()
                .response();
        response.getBody().print();
    }

}
