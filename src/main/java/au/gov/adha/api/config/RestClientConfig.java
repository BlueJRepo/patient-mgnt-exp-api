package au.gov.adha.api.config;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

import au.gov.adha.api.service.exceptions.DownstreamApiException;

@Configuration
public class RestClientConfig {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(RestClientConfig.class);
	
	@Value("${patient-mgnt-fhir-api-endpoint}")
	private String fhirEndpoint;
	
    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder
            .baseUrl(this.fhirEndpoint)
            .requestInterceptor((request, body, execution) -> {
                log.info("Request to base URL [{}]: {} {}", this.fhirEndpoint, request.getMethod(), request.getURI());
                var response = execution.execute(request, body);
                return response;
            })
            .defaultStatusHandler(
                    HttpStatusCode::isError, 
                    (request, response) -> {
                        // Extract the raw error body sent by the downstream API
                        String body = new String(response.getBody().readAllBytes(), StandardCharsets.UTF_8);
                        throw new DownstreamApiException(response.getStatusCode(), body);
                    }
            )
            .build();
    }
}
