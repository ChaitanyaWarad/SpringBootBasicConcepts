package com.javatpoint.exceptionHandler;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		return new ResponseEntity<>(prepareErrorJson(status, ex), status);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<>(prepareErrorJson(status, ex), status);
	}

	private String prepareErrorJson(HttpStatus status, Exception ex) {
		JSONObject errorJson = new JSONObject();
		try {
			errorJson.put("status", status.value());
			errorJson.put("error", status.getReasonPhrase());
			errorJson.put("message", ex.getMessage().split(":")[0]);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return errorJson.toString();
	}
}
