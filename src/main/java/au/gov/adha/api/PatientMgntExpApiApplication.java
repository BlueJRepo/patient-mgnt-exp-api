package au.gov.adha.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.core.StreamWriteConstraints;


@SpringBootApplication
public class PatientMgntExpApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientMgntExpApiApplication.class, args);
	}
	

}
