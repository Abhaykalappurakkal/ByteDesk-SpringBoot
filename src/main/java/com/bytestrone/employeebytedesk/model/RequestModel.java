package com.bytestrone.employeebytedesk.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RequestModel {

	@Id
	@Column(name = "request_id")
	private String requestId;
	@Column(name = "request_date")
	private LocalDateTime requestDate;
	@Column(name = "user_id")
	private String userId;

	@Column(name = "requested_dept")
	private String requestedDepartment;
	@Column(name = "ticket_summary")
	private String ticketSummary;
	@Column(name = "ticket_status")
	private String ticketStatus;
	@Column(name = "ticket_description")
	private String ticketDescription;
	@Column(name = "resolution")
	private String resolution;
	@Column(name = "resolved_date")
	private String resolvedDate;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public LocalDateTime getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRequestedDepartment() {
		return requestedDepartment;
	}

	public void setRequestedDepartment(String requestedDepartment) {
		this.requestedDepartment = requestedDepartment;
	}

	public String getTicketSummary() {
		return ticketSummary;
	}

	public void setTicketSummary(String ticketSummary) {
		this.ticketSummary = ticketSummary;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getTicketDescription() {
		return ticketDescription;
	}

	public void setTicketDescription(String ticketDescription) {
		this.ticketDescription = ticketDescription;
	}

	public String getResolvedDate() {
		return resolvedDate;
	}

	public void setResolvedDate(String resolvedDate) {
		this.resolvedDate = resolvedDate;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}
}
