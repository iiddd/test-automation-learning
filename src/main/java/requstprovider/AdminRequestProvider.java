package requstprovider;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class AdminRequestProvider extends BaseRequestProvider {
    public RequestSpecification createAdminAccount(String username, String password, Cookie cookie) {
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password1", password);
        params.put("password2", password);
        return getDefaultRequestSpecBuilder()
                .setBasePath("/app_users/create")
                .setContentType(ContentType.URLENC.withCharset("UTF-8"))
                .addFormParams(params)
                .addCookie(cookie)
                .build();
    }

    public RequestSpecification deleteAdminAccount(int id, Cookie cookie) {
        return getDefaultRequestSpecBuilder()
                .setBasePath("/app_users/delete/" + id + "/")
                .setContentType(ContentType.URLENC.withCharset("UTF-8"))
                .addCookie(cookie)
                .build();
    }
}
