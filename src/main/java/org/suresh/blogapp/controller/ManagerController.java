package org.suresh.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.suresh.blogapp.entity.MemberInformation;
import org.suresh.blogapp.entity.Task;
import org.suresh.blogapp.model.MemberInformationRequest;
import org.suresh.blogapp.service.ManagerService;

@RestController
@RequestMapping("/projectmgmt/api/v1/manager")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;

    @PostMapping("/add-member")
    public ResponseEntity<Object> addMember(@RequestBody MemberInformationRequest memberInformationRequest) {	
        return managerService.addMember(memberInformationRequest);
    } 
    
    @GetMapping("/list")
    public List<MemberInformation> getMemberDetails() {
        return managerService.getMemberDetails();
    }
    
    @PostMapping(value = "/assign-task", consumes="application/json")
    public ResponseEntity<Object> assignTask(@RequestBody Task task) {
        return managerService.assignTask(task);
    }

    @PutMapping("/update/{memberId}/{allocationPercentage}")
    public ResponseEntity<Object> updateAllocationPercentage(@PathVariable int memberId,
    		@PathVariable int allocationPercentage ) {
        return managerService.updateAllocationPercentage(memberId, allocationPercentage);
    }
}
