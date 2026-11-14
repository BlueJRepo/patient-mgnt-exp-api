package au.gov.adha.api.service;

import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

//import lombok.extern.slf4j.Slf4j;

@Service
//@Slf4j  Automatically injects: private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PatientServiceImpl.class)
public class PatientServiceImpl implements PatientService {

	
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PatientServiceImpl.class);
	
	@Autowired
	private RestClient restClient;

	public String getPatient(String patientId) {
		log.info("Get Patient by patientId: {}", patientId);

		String patientJson = restClient.get()
			    .uri("/{patientId}", patientId)
			    .accept(MediaType.APPLICATION_JSON)
			    .retrieve()
			    .body(String.class);
		log.info("Get Patient Response: {}", patientJson);
		return patientJson;
		
	}

	@Override
	public String receivePatient(String patientAsFhirJson) {
		//log.info("addPatient FHIR Endpoint: {}", fhirEndpoint);
	    String patientJson = restClient.post()
			    .contentType(MediaType.APPLICATION_JSON)
			    .body(patientAsFhirJson)
			    .retrieve()
			    .body(String.class);
	    log.info("Create Patient Response: {}", patientJson);
		return patientJson;
	}
}
