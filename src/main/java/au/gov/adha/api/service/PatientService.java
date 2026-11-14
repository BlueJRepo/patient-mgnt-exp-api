package au.gov.adha.api.service;

import org.hl7.fhir.r4.model.Patient;

public interface PatientService {
	public String getPatient(String patientId);

	public String receivePatient(String patientAsFhirJson);
}
