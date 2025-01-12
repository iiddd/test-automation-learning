package org.example.utils;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class RestUtils {
    public static ValidatableResponse delete(RequestSpecification request) {
        return given().log().all()
                .spec(request)
                .when()
                .delete()
                .then().log().all();
    }

    public static ValidatableResponse post(RequestSpecification request) {
        return given().log().all()
                .spec(request)
                .when()
                .post()
                .then().log().all();
    }

    public static ValidatableResponse put(RequestSpecification request) {
        return given().log().all()
                .spec(request)
                .when()
                .put()
                .then().log().all();
    }

    public static ValidatableResponse get(RequestSpecification request) {
        return given().log().all()
                .spec(request)
                .when()
                .get()
                .then().log().all();
    }
}
