package au.gov.adha.api.service.exceptions;

import org.springframework.http.HttpStatusCode;

public class DownstreamApiException extends RuntimeException {
    private final HttpStatusCode statusCode;
    private final String responseBody;

    public DownstreamApiException(HttpStatusCode statusCode, String responseBody) {
        super("Downstream error: " + statusCode);
        this.statusCode = statusCode;
        this.responseBody = responseBody;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public String getResponseBody() {
        return responseBody;
    }
}