package org.example;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

public class CourierChecks {

    @Step("Проверка: курьер не может быть создан без обязательных параметров")
    public static void badRequestCheck(ValidatableResponse createResponse) {
        String created = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .path("message", String.valueOf(equalTo("Недостаточно данных для создания учетной записи")));
    }

    @Step("Проверка: курьер не может войти без обязательных параметров")
    public void badRequestLogin(ValidatableResponse createResponse) {
        String created = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_BAD_REQUEST)
                .extract()
                .path("message", String.valueOf(equalTo("Недостаточно данных для входа")));
    }

    @Step("Проверка: курьер не найден при входе")
    public void notFoundLogin(ValidatableResponse createResponse) {
        String created = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_NOT_FOUND)
                .extract()
                .path("message", String.valueOf(equalTo("Учетная запись не найдена")));
    }

    @Step("Проверка: курьер не может быть создан с дублирующимся логином")
    public void conflictCheck(ValidatableResponse createResponse) {
        String created = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CONFLICT)
                .extract()
                .path("message", String.valueOf(equalTo("Этот логин уже используется. Попробуйте другой.")));
    }

    @Step("Проверка: курьер успешно вошел в систему")
    public int loggedInSuccessfully(ValidatableResponse loginResponse) {
        int id = loginResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("id");
        return id;
    }

    @Step("Проверка: курьер успешно создан")
    public void createdSuccessfully(ValidatableResponse createResponse) {
        boolean created = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_CREATED)
                .extract()
                .path("ok");
        assertTrue(created);
    }


    @Step("Проверка: курьер успешно удален")
    public void deletedSuccesfully(ValidatableResponse response) {
        boolean deleted = response
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("ok");
        assertTrue(deleted);
    }
}