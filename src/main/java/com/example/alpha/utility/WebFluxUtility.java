package com.example.alpha.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.alpha.pojo.EmployeeDto;
import com.google.gson.Gson;

import reactor.core.publisher.Mono;

@Component
public class WebFluxUtility {

	private final WebClient webClient;

	@Autowired
	public WebFluxUtility(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl(AppConstants.EMPLOYEE_SERVICE_BASE_URL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).build();
	}

	public List<EmployeeDto> getAllEmployees(final String depoId) {
		/*
		 * List<EmployeeDto> employeeDtos = webClient.get().uri("depo/" +
		 * depoId).retrieve() .bodyToMono(new
		 * ParameterizedTypeReference<List<EmployeeDto>>() {}).block(); //
		 * System.out.println("Employees : "+new Gson().toJson(employeeDtos));
		 * System.out.println(">>"); for(EmployeeDto employeeDto: employeeDtos) {
		 * System.out.println("Employee Name: "+employeeDto); }
		 * System.out.println(">>"); return employeeDtos;
		 */
		
		   try {
	            // Step 1 — fetch raw response as String first to check actual structure
			   List<EmployeeDto> employeeDtos = webClient
				        .get()
				        .uri("/depo/{id}", depoId)
				        .retrieve()
				        .bodyToMono(new ParameterizedTypeReference<List<EmployeeDto>>() {})
				        .block();
			   return employeeDtos;

	        } catch (Exception e) {
	            // log error
	        	e.printStackTrace();
	            System.err.println("Error fetching employees for Depo ID: " + depoId + " - " + e.getMessage());
	            return new ArrayList<>();
	        }
	}
}
