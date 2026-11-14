package au.gov.adha.api.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	//@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DownstreamApiException.class)
    public ResponseEntity<ProblemDetail> handleDownstreamException(DownstreamApiException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(
            ex.getStatusCode(), 
            ex.getResponseBody()
        );
        problemDetail.setTitle("Downstream Service Error");

        return ResponseEntity
            .status(ex.getStatusCode())
            .body(problemDetail);
    }
}