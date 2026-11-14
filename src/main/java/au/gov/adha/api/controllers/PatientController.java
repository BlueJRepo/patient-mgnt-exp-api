package au.gov.adha.api.controllers;

import org.hl7.fhir.r4.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import lombok.extern.slf4j.Slf4j;

import au.gov.adha.api.service.PatientService;
import ca.uhn.fhir.context.FhirContext;

@RestController
@RequestMapping("/mgnt")
//@Slf4j Automatically injects: private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PatientController.class)
public class PatientController {

	org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(PatientController.class);
	
	private final FhirContext fhirContext = FhirContext.forR4();
	
	@Autowired
	private PatientService patientService;

	@GetMapping("/Patient/{patientId}")
	public String getPatientById(@PathVariable String patientId) {
	    return patientService.getPatient(patientId);
	}
	
	@PostMapping("/Patient")
	public String receivePatient(@RequestBody String patientAsFhirJson) {
		//Patient patient = fhirContext.newJsonParser().parseResource(Patient.class, patientAsFhirJson);
	    return patientService.receivePatient(patientAsFhirJson);
	}
	
}
