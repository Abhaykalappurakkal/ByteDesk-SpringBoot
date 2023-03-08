package com.employeeBytedesk.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.bytestrone.employeebytedesk.model.RequestModel;
import com.bytestrone.employeebytedesk.repository.RequestRepo;
import com.bytestrone.employeebytedesk.service.RequestService;
import com.bytestrone.employeebytedesk.serviceimpl.RequestServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = RequestServiceImpl.class)
class RequestServiceImplTest {

	@Autowired
	private RequestService service;

	@MockBean
	private RequestRepo repo;

	@Test
	@DisplayName("Test Save Request Success")
	void testSaveRequest() {
		RequestModel request = new RequestModel();
		service.saveRequest(request);
		verify(repo, times(1)).save(request);
	}

	@Test
	@DisplayName("Test Save Request Failure")
	void testSaveRequestFailure() {
		RequestModel request = null;
		service.saveRequest(request);
		verify(repo, times(0)).save(request);
	}

	@Test
	@DisplayName("Test cancel Request success")
	void testCancelRequest() {
		RequestModel request = new RequestModel();
		request.setRequestId("REQ1234");
		request.setTicketStatus("open");
		when(repo.findByRequestId("REQ1234")).thenReturn(request);
		service.cancelRequest(request, "REQ1234");
		RequestModel updateRequest = repo.findByRequestId("REQ1234");
		assertEquals("cancelled", updateRequest.getTicketStatus());
		verify(repo).save(updateRequest);
	}

	@Test
	@DisplayName("Test cancel Request failure")
	void testCancelRequestFailure() {
		RequestModel request = new RequestModel();
		request.setRequestId("REQ1234");
		request.setTicketStatus("open");
		when(repo.findByRequestId("REQ1234")).thenReturn(request);
		service.cancelRequest(request, "REQ1234");
		RequestModel updateRequest = repo.findByRequestId(null);
		verify(repo, times(0)).save(updateRequest);
	}

	@Test
	@DisplayName("Test get list of userId and status success")
	void testGetListOfUserIdAndStatus() {

		int pageNumber = 2;
		int pageSize = 10;
		String userId = "exampleId";
		String status = "open";
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<RequestModel> abc = createDummyPage();
		when(repo.findRequestModelByUserIdAndTicketStatus(pageable, userId, status)).thenReturn(abc);

		// when
		Page<RequestModel> result = service.getListOfUserIdAndStatus(pageNumber, pageSize, userId, status);

		// then
		assertEquals(abc, result);

	}

	private Page<RequestModel> createDummyPage() {
		// TODO Auto-generated method stub
		Page<RequestModel> model = new Page<RequestModel>() {

			@Override
			public Iterator<RequestModel> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Pageable previousPageable() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Pageable nextPageable() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean isLast() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isFirst() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasPrevious() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean hasContent() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Sort getSort() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getSize() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getNumberOfElements() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public int getNumber() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public List<RequestModel> getContent() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <U> Page<U> map(Function<? super RequestModel, ? extends U> converter) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getTotalPages() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public long getTotalElements() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		return model;
	}

	@Test
	@DisplayName("Test get list of userId and status failure")
	void testGetListOfUserIdAndStatusFailure() {
		int pageNumber = 0;
		int pageSize = 10;
		String userId = "exampleId";
		String status = "pass";
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<RequestModel> abc = createDummyPage();
		when(repo.findRequestModelByUserIdAndTicketStatus(pageable, userId, status)).thenReturn(abc);

		Page<RequestModel> result = service.getListOfUserIdAndStatus(pageNumber, pageSize, null, null);

		verify(repo, times(0)).findRequestModelByUserIdAndTicketStatus(pageable, userId, status);
	}
	
	@Test
	@DisplayName("Test close request success")
	void testCloseRequest() {
		RequestModel request = new RequestModel();
		request.setRequestId("REQ1234");
		request.setTicketStatus("resolved");
		when(repo.findByRequestId("REQ1234")).thenReturn(request);
		service.closeRequest(request, "REQ1234");
		RequestModel updateRequest = repo.findByRequestId("REQ1234");
		assertEquals("closed", updateRequest.getTicketStatus());
		verify(repo).save(updateRequest);
	}
	
	@Test
	@DisplayName("Test close Request failure")
	void testCloseRequestFailure() {
		RequestModel request = new RequestModel();
		request.setRequestId("REQ1234");
		request.setTicketStatus("resolved");
		when(repo.findByRequestId("REQ1234")).thenReturn(request);
		service.closeRequest(request, "REQ1234");
		RequestModel updateRequest = repo.findByRequestId(null);
		verify(repo, times(0)).save(updateRequest);
	}
	
	@Test
	@DisplayName("Test get list of userId and department success")
	void testGetListOfUserIdAndDept() {

		int pageNumber = 2;
		int pageSize = 10;
		String userId = "exampleId";
		String dept = "IT";
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<RequestModel> abc = createDummyPage();
		when(repo.findRequestModelByUserIdAndRequestedDepartment(pageable, userId, dept)).thenReturn(abc);

		// when
		Page<RequestModel> result = service.getListOfUserIdAndDept(pageNumber, pageSize, userId, dept);

		// then
		assertEquals(abc, result);

	}
	
	@Test
	@DisplayName("Test get list of userId and department failure")
	void testGetListOfUserIdAndDeptFailure() {
		int pageNumber = 0;
		int pageSize = 10;
		String userId = "exampleId";
		String dept = "dept";
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<RequestModel> abc = createDummyPage();
		when(repo.findRequestModelByUserIdAndRequestedDepartment(pageable, userId, dept)).thenReturn(abc);

		Page<RequestModel> result = service.getListOfUserIdAndDept(pageNumber, pageSize, null, null);

		verify(repo, times(0)).findRequestModelByUserIdAndTicketStatus(pageable, userId, dept);
	}


}
