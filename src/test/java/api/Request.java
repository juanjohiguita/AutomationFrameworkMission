package api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.awaitility.core.ConditionFactory;

import java.util.Objects;

public class Request {
    protected RequestSpecification requestSpecification;
    private int expectedStatus = 200;
    private ConditionFactory await = null;


    public Request() {
        this.requestSpecification = RestAssured
                .given()
                .filter(new AllureRestAssured())
                .filter(new RequestLoggingFilter(LogDetail.ALL, false, System.out))
                .filter(new ResponseLoggingFilter(LogDetail.ALL, false, System.out))
                .relaxedHTTPSValidation()
                .redirects()
                .follow(false);
    }

    public Request baseUri(String baseUri) {
        this.requestSpecification.baseUri(baseUri);
        return this;
    }

    public Request contentType(ContentType contentType) {
        this.requestSpecification.contentType(contentType);
        return this;
    }

    public Response get() {
        return waitableRequest(Method.GET);
    }


    private Response waitableRequest(Method method) {
        Response response = sendRequest(method);
        if (!Objects.isNull(response)
                && !Objects.isNull(this.await)
                && !Objects.isNull(response.getResponse())
                && response.getResponse().getStatusCode() != this.expectedStatus) {
            this.await
                    .until(() -> sendRequest(method).getResponse().getStatusCode() == this.expectedStatus);
        }
        return response;
    }

    private Response waitableRequest(Method method, String path) {
        Response response = sendRequest(method, path);
        if (!Objects.isNull(response)
                && !Objects.isNull(this.await)
                && !Objects.isNull(response.getResponse())
                && response.getResponse().getStatusCode() != this.expectedStatus) {
            this.await.until(() ->
                    Objects.requireNonNull(sendRequest(method, path))
                            .getResponse().getStatusCode() == this.expectedStatus);
        }
        return response;
    }

    private Response sendRequest(Method method) {
        ValidatableResponse response = this.requestSpecification
                .request(method)
                .then();

        if (!Objects.isNull(response) && !Objects.isNull(response.extract())) {
            return new Response(response.extract().response());
        }

        return null;
    }

    private Response sendRequest(Method method, String path) {
        ValidatableResponse response = this.requestSpecification
                .basePath(path)
                .request(method)
                .then();

        if (!Objects.isNull(response) && !Objects.isNull(response.extract())) {
            return new Response(response.extract().response());
        }

        return null;
    }

    public Response get(String path) {
        return waitableRequest(Method.GET, path);
    }
}
