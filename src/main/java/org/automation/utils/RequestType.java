package org.automation.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * request type methods GET,DELETE
 */

public class RequestType {

    public Response get(String url)
    {
        return RestAssured.given()
                .header("Content-Type","application/json")
                .log().all()
                .when()
                .get(url);
    }

    public Response delete(String url)
    {
        return RestAssured.given()
                .header("Content-Type","application/json")
                .log().all()
                .when()
                .delete(url);
    }
}
