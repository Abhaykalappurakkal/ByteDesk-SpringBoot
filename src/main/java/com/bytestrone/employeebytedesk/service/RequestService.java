package com.bytestrone.employeebytedesk.service;

import org.springframework.data.domain.Page;

import com.bytestrone.employeebytedesk.model.RequestModel;

public interface RequestService {

	RequestModel saveRequest(RequestModel request);

	RequestModel cancelRequest(RequestModel request, String requestId);

	RequestModel closeRequest(RequestModel request, String requestId);

	Page<RequestModel> getListOfUserIdAndStatus(int pageNumber, int pageSize, String userId, String status);

	Page<RequestModel> getListOfUserIdAndDept(int pageNumber, int pageSize, String userId, String dept);

}
