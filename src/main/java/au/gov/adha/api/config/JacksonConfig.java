package au.gov.adha.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonConfig {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JacksonConfig.class);
	
//	@Value("${fhir-json-max-depth}")
//	private int fhirJsonMaxDepth;
//	
//	@Bean
//	public ObjectMapper objectMapper() {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setVisibility(PropertyAccessor.ALL, Visibility.NONE);
//		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
//        // Increase maximum allowed writing depth to 2000
//        StreamWriteConstraints constraints = StreamWriteConstraints.builder()
//                .maxNestingDepth(fhirJsonMaxDepth)
//                .build();
//        mapper.getFactory().setStreamWriteConstraints(constraints);		
//		return mapper;
//	}
}
