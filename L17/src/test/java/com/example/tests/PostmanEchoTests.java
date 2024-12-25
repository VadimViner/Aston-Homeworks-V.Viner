package com.example.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostmanEchoTests {

    static {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetResponseCodeAndBody() {
        Response response = given()
                .queryParam("Hello1", "bar1")
                .queryParam("Hello2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .extract()
                .response();

        assertEquals("bar1", response.jsonPath().getString("args.Hello1"), "Поле Hello1 не совпадает");
        assertEquals("bar2", response.jsonPath().getString("args.Hello2"), "Поле Hello2 не совпадает");
    }

    @Test
    public void testGetBodyDirectValidation() {
        given()
                .queryParam("Hello1", "bar1")
                .queryParam("Hello2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.Hello1", equalTo("bar1"))
                .body("args.Hello2", equalTo("bar2"));
    }

    @Test
    public void testPostRawText() {

        // POST-запрос с Raw Text
        given()
                .header("Content-Type", "application/json")
                .body("{\"key1\":\"value1\",\"key2\":\"value2\"}")
                .when()
                .post("/post")
                .then()
                .statusCode(200) // Проверка кода ответа
                .body("data.key1", equalTo("value1"))
                .body("data.key2", equalTo("value2"));
    }

    @Test
    // тест падает, пока не разобрался почему. в Postman все перепроверил - код 200, а здесь 500
    public void testPostFormData() {
        Response response = given()
                .header("Content-Type", "application/x-www-form-urlencoded; charset=utf-8")
                .formParam("key1", "value1")
                .formParam("key2", "value2")
                .when()
                .post("https://postman-echo.com/post")
                .then()
                .statusCode(200) // Проверка кода ответа
                .extract()
                .response();

        assertEquals("value1", response.jsonPath().getString("form.key1"), "Поле key1 не совпадает");
        assertEquals("value2", response.jsonPath().getString("form.key2"), "Поле key2 не совпадает");
    }



    @Test
    public void testPutRequest() {

        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\"key1\":\"value1\",\"key2\":\"value2\"}")
                .when()
                .put("/put")
                .then()
                .statusCode(200) //
                .extract()
                .response(); //

        // Проверяем, что сервер вернул те же данные
        assertEquals("value1", response.jsonPath().getString("json.key1"), "Поле key1 не совпадает");
        assertEquals("value2", response.jsonPath().getString("json.key2"), "Поле key2 не совпадает");
    }


    @Test
    public void testPutBodyDirectValidation() {


        given()
                .header("Content-Type", "application/json") // Устанавливаем заголовок
                .body("{\"key1\":\"value1\",\"key2\":\"value2\"}") // Указываем тело запроса
                .when()
                .put("/put") // Выполняем PUT-запрос
                .then()
                .statusCode(200) // Проверяем статус-код
                .body("json.key1", equalTo("value1")) // Проверяем поле key1
                .body("json.key2", equalTo("value2")); // Проверяем поле key2
    }
    @Test
    public void testPatchRequest() {
        // URL для отправки PATCH запроса
        String url = "https://postman-echo.com/patch";
        // Тело запроса
        String requestBody = "{\"key\":\"newValue\"}";
        // Отправка PATCH запроса
        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch(url);

        // Вывод тела ответа и статус-кода
        System.out.println("Response body: " + response.getBody().asString());
        System.out.println("Status code: " + response.getStatusCode());

        // Проверка статус-кода и содержимого ответа
        response.then()
                .statusCode(200)
                .body("data.key", equalTo("newValue")); // Проверка, что значение ключа обновлено
    }

    @Test
    public void testDeleteRequest() {
        // Сгенерировал ID вручную
        String resourceId = "123";
        String requestBody = "{\"id\":\"" + resourceId + "\",\"key\":\"value\"}";

        Response postResponse = given()
                .header("Content-Type", "application/json") // Устанавливаем заголовок
                .body(requestBody) // Указываем тело запроса
                .when()
                .post("/post") // Выполняем POST-запрос
                .then()
                .statusCode(200) // Проверяем успешный статус ответа
                .extract()
                .response();

        // Выводим тело ответа POST-запроса
        System.out.println("Ответ на POST-запрос: " + postResponse.getBody().asString());

        // Проверяем, что ID был возвращен корректно
        String returnedId = postResponse.jsonPath().getString("data.id");
        System.out.println("Создан ресурс с ID: " + returnedId);
        assertEquals(resourceId, returnedId, "ID не совпадает!");

        // 2. Удаляем "ресурс" с помощью DELETE-запроса
        Response deleteResponse = given()
                .header("Content-Type", "application/json")
                .body("{\"id\":\"" + resourceId + "\"}")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // 3. Проверяем тело ответа после удаления
        System.out.println("Тело ответа на DELETE-запрос: " + deleteResponse.getBody().asString());
        String deletedId = deleteResponse.jsonPath().getString("data.id");
        assertEquals(resourceId, deletedId, "ID удалённого ресурса не совпадает!");
    }

}
