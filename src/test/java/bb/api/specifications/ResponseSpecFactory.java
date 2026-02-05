package bb.api.specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

/**
 * ResponseSpecFactory:
 * - Contains shared response specifications
 * - Applied to all API calls to standardize validation and logging
 */
public class ResponseSpecFactory {

    private static ResponseSpecification DEFAULT_SPEC;
    private static ResponseSpecification LENIENT_SPEC;

    private ResponseSpecFactory() {
        // Prevent initialization
    }

    public static ResponseSpecification defaultSpec() {

        if (DEFAULT_SPEC == null) {
            DEFAULT_SPEC = new ResponseSpecBuilder()
                    // APIs usually return JSON
                    .expectContentType("application/json")

                    // Log full response (headers + body)
                    .log(LogDetail.ALL)
                    .build();
        }

        return DEFAULT_SPEC;
    }

    /**
     * Lenient Response Specification:
     * - Does not check content-type
     * - Used when the API returns text/html or non-standard responses
     */
    public static ResponseSpecification lenientSpec() {

        if (LENIENT_SPEC == null) {
            LENIENT_SPEC = new ResponseSpecBuilder()
                    // No JSON expectation

                    // Log response for debugging
                    .log(LogDetail.ALL)

                    .build();
        }

        return LENIENT_SPEC;
    }

    /**
     * Create a response specification with an expected status code
     */
    public static ResponseSpecification statusSpec(int expectedStatusCode) {

        return new ResponseSpecBuilder()
                .expectStatusCode(expectedStatusCode)
                .log(LogDetail.ALL)
                .build();
    }
}
