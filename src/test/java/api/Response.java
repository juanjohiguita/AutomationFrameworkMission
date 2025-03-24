package api;

import io.restassured.response.ResponseBody;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.hamcrest.Matcher;
import org.w3c.dom.Node;

@Getter
@Data
@AllArgsConstructor
public class Response {
    private io.restassured.response.Response response;

    public ResponseBody getBody() {
        return this.response.body();
    }

    public Response status(org.hamcrest.Matcher<Integer> matcher) {
        this.response.then().statusCode(matcher);
        return this;
    }

    public <T> Response body(String path, org.hamcrest.Matcher<T> matcher) {
        this.response.then().body(path, matcher);
        return this;
    }

    public <T> Response body(org.hamcrest.Matcher<T> matcher) {
        this.response.then().body("", matcher);
        return this;
    }

    public <T> Response body(Matcher<Node> node, org.hamcrest.Matcher<T> matcher) {
        this.response.then().body(node, matcher);
        return this;
    }

    public io.restassured.response.Response getResponse() {
        return this.response;
    }
}
