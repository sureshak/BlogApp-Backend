package org.suresh.blogapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.suresh.blogapp.entity.Task;
import org.suresh.blogapp.service.MemberService;

@RestController
@RequestMapping("/projectmgmt/api/v1/member")
public class MemberController {
	
	@Autowired
	MemberService memberService;

	@GetMapping("/list/{memberId}")
    public ResponseEntity<Task> getTaskDetails(@PathVariable int memberId) {
        return ResponseEntity.ok(memberService.getTaskDetail(memberId));
    }
}
