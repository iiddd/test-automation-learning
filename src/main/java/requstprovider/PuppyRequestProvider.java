package requstprovider;

import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.specification.RequestSpecification;
import org.example.models.rest.Puppy;

import java.util.HashMap;
import java.util.Map;

public class PuppyRequestProvider extends BaseRequestProvider {
    public RequestSpecification createPuppyAccount(Puppy puppy, Cookie cookie) {
        Map<String, String> params = new HashMap<>();
        params.put("account_number", puppy.getAccountNumber());
        params.put("account_balance", Float.toString(puppy.getAccountBalance()));
        params.put("first_name", puppy.getFirstName());
        params.put("last_name", puppy.getLastName());
        params.put("address", puppy.getAddress());
        params.put("mobile_number", puppy.getMobileNumber());
        params.put("email_address", puppy.getEmailAddress());
        return getDefaultRequestSpecBuilder()
                .setBasePath("/app_clients/create")
                .setContentType(ContentType.URLENC.withCharset("UTF-8"))
                .addFormParams(params)
                .addCookie(cookie)
                .build();
    }

    public RequestSpecification deletePuppyAccount(int id, Cookie cookie) {
        return getDefaultRequestSpecBuilder()
                .setBasePath("/app_clients/delete/" + id + "/")
                .setContentType(ContentType.URLENC.withCharset("UTF-8"))
                .addCookie(cookie)
                .build();
    }
}
