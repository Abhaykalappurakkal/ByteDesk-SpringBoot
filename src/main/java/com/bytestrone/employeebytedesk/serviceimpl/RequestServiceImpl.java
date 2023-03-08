package com.bytestrone.employeebytedesk.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.bytestrone.employeebytedesk.model.RequestModel;
import com.bytestrone.employeebytedesk.repository.RequestRepo;
import com.bytestrone.employeebytedesk.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestRepo repo;

	@Override
	public RequestModel saveRequest(RequestModel request) {
		return repo.save(request);
	}

	@Override
	public RequestModel cancelRequest(RequestModel request, String requestId) {
		RequestModel excistingRequest = repo.findByRequestId(requestId);
		excistingRequest.setTicketStatus("cancelled");
		repo.save(excistingRequest);
		return excistingRequest;
	}

	@Override
	public RequestModel closeRequest(RequestModel request, String requestId) {
		RequestModel excistingRequest = repo.findByRequestId(requestId);
		excistingRequest.setTicketStatus("closed");
		repo.save(excistingRequest);
		return excistingRequest;
	}

	@Override
	public Page<RequestModel> getListOfUserIdAndStatus(int pageNumber, int pageSize, String userId, String status) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return repo.findRequestModelByUserIdAndTicketStatus(pageable, userId, status);
	}

	@Override
	public Page<RequestModel> getListOfUserIdAndDept(int pageNumber, int pageSize, String userId, String dept) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return repo.findRequestModelByUserIdAndRequestedDepartment(pageable, userId, dept);
	}

}
