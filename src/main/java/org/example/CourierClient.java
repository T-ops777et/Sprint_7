package org.example;


import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import org.example.Client;

import java.util.Map;

public class CourierClient {

    @Step("Вход курьера")
    public ValidatableResponse loginCourier(CourierEntry creds) {
        return Client.getRequestSpecification()
                .body(creds)
                .when().log().all()
                .post(Client.COURIER_LOGIN)
                .then().log().all();
    }

    @Step("Создание курьера")
    public ValidatableResponse createCourier(Courier courier) {
        return Client.getRequestSpecification()
                .and()
                .body(courier)
                .when().log().all()
                .post(Client.COURIER)
                .then().log().all();
    }

    @Step("Удаление курьера")
    public ValidatableResponse deleteCourier(int id) {
        return Client.getRequestSpecification()
                .body(Map.of("id", id))
                .when().log().all()
                .delete(Client.COURIER + "/" + id)
                .then().log().all();
    }
}
