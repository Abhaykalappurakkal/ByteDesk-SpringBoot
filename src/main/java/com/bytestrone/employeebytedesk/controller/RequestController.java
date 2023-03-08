package com.bytestrone.employeebytedesk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bytestrone.employeebytedesk.model.RequestModel;
import com.bytestrone.employeebytedesk.service.RequestService;

@RestController
@RequestMapping("/request")
@CrossOrigin(origins = "http://localhost:4200")
public class RequestController {

	@Autowired
	private RequestService service;

	// to raise new open request
	@PostMapping("/create")
	public ResponseEntity<RequestModel> saveRequestModel(@RequestBody RequestModel request) {
		return new ResponseEntity<>(service.saveRequest(request), HttpStatus.CREATED);
	}

	// to cancel an existing open request
	@PutMapping("/cancel/{requestId}")
	public ResponseEntity<RequestModel> cancelRequestModel(@PathVariable("requestId") String requestId,
			@RequestBody RequestModel request) {
		return new ResponseEntity<>(service.cancelRequest(request, requestId), HttpStatus.OK);
	}

	// to close an existing resolved request
	@PutMapping("/close/{requestId}")
	public ResponseEntity<RequestModel> closeRequestModel(@PathVariable("requestId") String requestId,
			@RequestBody RequestModel request) {
		return new ResponseEntity<>(service.closeRequest(request, requestId), HttpStatus.OK);
	}

	// to get the request details based on userId and ticket status
	@GetMapping("/list/{pageNumber}/{pageSize}/{userId}/status/{status}")
	public ResponseEntity<Map<String, Object>> getRequestByUserIdAndStatus(@PathVariable("pageNumber") int pageNumber,
			@PathVariable("pageSize") int pageSize, @PathVariable("userId") String userId,
			@PathVariable("status") String status) {
		Page<RequestModel> totalRequests = service.getListOfUserIdAndStatus(pageNumber, pageSize, userId, status);
		List<RequestModel> listOfRequests = totalRequests.getContent();
//		listOfRequests.forEach(t)
		Map<String, Object> response = new HashMap<>();
		response.put("userRequests", listOfRequests);
		response.put("currentPage", totalRequests.getNumber());
		response.put("totalItems", totalRequests.getTotalElements());
		response.put("totalPages", totalRequests.getTotalPages());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// to get the request details based on the userId and requested department
	@GetMapping("/list/{pageNumber}/{pageSize}/{userId}/dept/{department}")
	public ResponseEntity<Map<String, Object>> getRequestByUserIdAndDepartment(
			@PathVariable("pageNumber") int pageNumber, @PathVariable("pageSize") int pageSize,
			@PathVariable("userId") String userId, @PathVariable("department") String dept) {
		Page<RequestModel> totalRequests = service.getListOfUserIdAndDept(pageNumber, pageSize, userId, dept);
		List<RequestModel> listofRequests = totalRequests.getContent();
		Map<String, Object> response = new HashMap<>();
		response.put("userRequests", listofRequests);
		response.put("currentPage", totalRequests.getNumber());
		response.put("totalItems", totalRequests.getTotalElements());
		response.put("totalPages", totalRequests.getTotalPages());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
