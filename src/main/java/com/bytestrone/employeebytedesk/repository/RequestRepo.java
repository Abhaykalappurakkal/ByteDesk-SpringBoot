package com.bytestrone.employeebytedesk.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytestrone.employeebytedesk.model.RequestModel;

@Repository
public interface RequestRepo extends JpaRepository<RequestModel, String> {

	RequestModel findByRequestId(String requestId);

	Page<RequestModel> findRequestModelByUserIdAndTicketStatus(Pageable pageable, String userId, String status);

	Page<RequestModel> findRequestModelByUserIdAndRequestedDepartment(Pageable pageable, String userId, String dept);

}
