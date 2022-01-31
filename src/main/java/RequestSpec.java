import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class RequestSpec {

    protected  RequestSpecification requestSpec = new RequestSpecBuilder()
            .setBaseUri("https://petstore.swagger.io/v2")
            .setRelaxedHTTPSValidation()
            .setAccept(ContentType.JSON)
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

}
