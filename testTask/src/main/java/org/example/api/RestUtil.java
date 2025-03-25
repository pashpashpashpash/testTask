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

    public RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(propertiesUtil.getTestProps().getProperty("baseUrl"))
                .addHeader("Authorization", propertiesUtil.getTestProps().getProperty("apiToken"))
                .log(LogDetail.ALL)
                .build();
    }
}
