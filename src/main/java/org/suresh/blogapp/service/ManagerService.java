package org.suresh.blogapp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.suresh.blogapp.entity.MemberInformation;
import org.suresh.blogapp.entity.Task;
import org.suresh.blogapp.model.MemberInformationRequest;


/**
 * @author cogjava3381
 *
 */
public interface ManagerService {
	
	ResponseEntity<Object> addMember(MemberInformationRequest memberInformationRequest);
	
	ResponseEntity<Object> assignTask(Task task);
	
	ResponseEntity<Object> updateAllocationPercentage(int memberId, int allocationPercentage);

	List<MemberInformation> getMemberDetails();
}
