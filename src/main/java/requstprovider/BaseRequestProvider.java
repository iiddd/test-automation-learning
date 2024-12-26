package requstprovider;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;

public class BaseRequestProvider {

    private static final String BASE_API_URL = "http://localhost:8000";

    protected static RequestSpecBuilder getDefaultRequestSpecBuilder() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_API_URL)
                .setConfig(getConfig());
    }

    protected static RestAssuredConfig getConfig() {
        return new RestAssuredConfig().objectMapperConfig(new ObjectMapperConfig().defaultObjectMapperType(ObjectMapperType.GSON));
    }
}
