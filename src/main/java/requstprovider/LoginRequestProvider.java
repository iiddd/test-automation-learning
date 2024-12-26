package requstprovider;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class LoginRequestProvider extends BaseRequestProvider {

    public RequestSpecification prepareLoginRequest() {
        Map<String, String> params = new HashMap<>();
        params.put("username", "admin");
        params.put("password", "password");
        return getDefaultRequestSpecBuilder()
                .setBasePath("/app_generic/login")
                .setContentType(ContentType.URLENC.withCharset("UTF-8"))
                .addFormParams(params)
                .build();
    }
}
