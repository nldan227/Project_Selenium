package bb.api.specifications;

import bb.utils.DataUtils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestSpecFactory {

    private static RequestSpecification DEFAULT_SPEC;

    private RequestSpecFactory() {
        // prevent initialization
    }

    /**
     * Default Request Specification:
     * - Default JSON headers
     * - Relaxed HTTPS validation
     * - Request logging for debugging purposes
     */
    public static RequestSpecification defaultSpec() {

        if (DEFAULT_SPEC == null) {
            String baseUrl = DataUtils.getValueConf("api.base.url");

            if (baseUrl == null || baseUrl.isBlank()) {
                throw new RuntimeException(
                        "api.base.url is NOT configured in serenity.conf environments!"
                );
            }

            DEFAULT_SPEC = new RequestSpecBuilder()
                    .setBaseUri(baseUrl)
                    .setRelaxedHTTPSValidation()

                    // default headers
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept", "application/json")
                    .log(LogDetail.ALL)
                    .build();
        }

        return DEFAULT_SPEC;
    }

    /**
     * Create a request specification with additional custom headers
     */
    public static RequestSpecification withHeaders(Map<String, String> headers) {
        return new RequestSpecBuilder()
                .addRequestSpecification(defaultSpec())
                .addHeaders(headers)
                .build();
    }

    /**
     * Create a request specification with Bearer Token authorization
     */
    public static RequestSpecification withBearerToken(String token) {

        return new RequestSpecBuilder()
                .addRequestSpecification(defaultSpec())
                .addHeader("Authorization", "Bearer " + token)
                .build();
    }

    /**
     * Create a request specification with Bearer Token authorization and custom headers
     */
    public static RequestSpecification withBearerToken(String token, Map<String, String> headers) {
        return new RequestSpecBuilder()
                .addRequestSpecification(defaultSpec())
                .addHeader("Authorization", "Bearer " + token)
                .addHeaders(headers)
                .build();
    }
}
