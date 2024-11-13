package org.example.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.util.PropertiesUtil;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestUtil {

    private PropertiesUtil propertiesUtil = new PropertiesUtil();

    private RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(propertiesUtil.getTestProps().getProperty("baseUrl"))
                .log(LogDetail.ALL)
                .build();
    }

    public Response getWithParams(String uri, Map<String, String> params) {
        RequestSpecification requestSpecification = given(getRequestSpecification());
        for (Map.Entry<String, String> param : params.entrySet()) {
            requestSpecification.queryParam(param.getKey(), param.getValue());
        }
       return requestSpecification.get(uri);
    }

    public Response postWithParams(String uri, Map<String, String> params) {
        RequestSpecification requestSpecification = given(getRequestSpecification())
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(params);
        return requestSpecification.post(uri);
    }

    public Response delete(String uri) {
        RequestSpecification requestSpecification = given(getRequestSpecification());
        return requestSpecification.delete(uri);
    }
}
