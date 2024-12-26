package requstprovider;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class LoginRequestProvider extends BaseRequestProvider {

    public RequestSpecification prepareLoginRequest() {
        Map<String, String> params = new HashMap<>();
        params.put("username", "admin");
        params.put("password", "password");
        return getDefaultRequestSpecBuilder()
                .setBasePath("/app_generic/login")
                .setContentType(ContentType.URLENC)
                .addHeader("Accept-Encoding", "gzip, deflate, br")
                .addFormParams(params)
                .build();
    }
}
