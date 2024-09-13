package org.example;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Client {

    public static final String ORDERS = "/orders";
    public static final String COURIER = "/courier";
    public static final String COURIER_LOGIN = "/courier/login";
    public static final String BASE_URI = "https://qa-scooter.praktikum-services.ru/api/v1";

    public static RequestSpecification getRequestSpecification() {
        return given().log().all()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URI);
    }

}
