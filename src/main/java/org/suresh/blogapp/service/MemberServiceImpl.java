package org.suresh.blogapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.suresh.blogapp.entity.Task;
import org.suresh.blogapp.repository.TaskRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public Task getTaskDetail(Integer memberId) {
		
		Optional<Task> availableTask =  taskRepository.findByMemberId(memberId);
		if(!availableTask.isEmpty()) {
			return taskRepository.findByMemberId(memberId).get();
		}
		return null;
	}
}
