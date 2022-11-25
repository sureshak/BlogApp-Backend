package org.suresh.blogapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.suresh.blogapp.Exception.ExperienceNotMatchingException;
import org.suresh.blogapp.Exception.MemberInformationNotFoundException;
import org.suresh.blogapp.Exception.MemberNotFoundException;
import org.suresh.blogapp.Exception.SkillSetNotMatchingException;
import org.suresh.blogapp.entity.MemberInformation;
import org.suresh.blogapp.entity.SkillSet;
import org.suresh.blogapp.entity.Task;
import org.suresh.blogapp.model.MemberInformationRequest;
import org.suresh.blogapp.model.MessageResponse;
import org.suresh.blogapp.repository.MemberInformationRepository;
import org.suresh.blogapp.repository.SkillSetRepository;
import org.suresh.blogapp.repository.TaskRepository;


/**
 * @author cogjava3381
 *
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	MemberInformationRepository memberInformationRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Autowired
	SkillSetRepository skillSetRepository;

	/**
	 * Save member information
	 * 
	 * @param MemberInformationRequest
	 * @return ResponseEntity<Object>
	 */
	@Override
	public ResponseEntity<Object> addMember(MemberInformationRequest memberInformationRequest) {
		if(memberInformationRequest != null) {
			if(memberInformationRequest.getExperience() >= 4) {
				MemberInformation memberInformation = new MemberInformation();
				memberInformation.setAdditionalInfo(memberInformationRequest.getAdditionalInfo());
				memberInformation.setAllocationPercentage(memberInformationRequest.getAllocationPercentage());
				memberInformation.setEndDate(memberInformationRequest.getEndDate());
				memberInformation.setExperience(memberInformationRequest.getExperience());
				memberInformation.setName(memberInformationRequest.getName());
				memberInformation.setStartDate(memberInformationRequest.getStartDate());
				MemberInformation response = memberInformationRepository.save(memberInformation);
				saveSkillSet(memberInformationRequest,response.getMemberId() );
			}else {
				throw new ExperienceNotMatchingException();
			}
		}else {
			throw new MemberInformationNotFoundException();
		}	
		return ResponseEntity.ok(new MessageResponse("Member added successfully"));
	}

	/**
	 * Save skill set
	 * 
	 * @param memberInformationRequest
	 */
	@Transactional
	private void saveSkillSet(MemberInformationRequest memberInformationRequest, int memberId) {
		if(memberInformationRequest.getSkillset().size() >= 3) {		
			for(String skillSetData : memberInformationRequest.getSkillset()) {
				System.out.println("data 1---->"+skillSetData);
				SkillSet skillSet = new SkillSet();
				skillSet.setMemberId(memberId);
				skillSet.setSkill(skillSetData);
				skillSetRepository.save(skillSet);
			}
		}else {
			throw new SkillSetNotMatchingException();
		}
	}

	@Override
	public List<MemberInformation> getMemberDetails() {
		return memberInformationRepository.findAll();
	}

	@Override
	public ResponseEntity<Object> assignTask(Task task) {
		Optional<MemberInformation> memberInformation = memberInformationRepository.findById(task.getMemberId());
		if(!memberInformation.isEmpty()) {
			Optional<Task> taskInformation = taskRepository.findByMemberId(task.getMemberId());
			if(!taskInformation.isEmpty()) {
				Task availableTask = taskInformation.get();
				availableTask.setDeliverable(task.getDeliverable());
				availableTask.setEndDate(task.getEndDate());
				availableTask.setMemberId(task.getMemberId());
				availableTask.setStartDate(task.getStartDate());
				availableTask.setTaskId(task.getTaskId());
				availableTask.setTaskName(task.getTaskName());
				taskRepository.save(availableTask);
			}
			taskRepository.save(task);
		}else {
			throw new MemberNotFoundException();
		}
		return ResponseEntity.ok(new MessageResponse("Task assigned successfully"));
	}

	@Override
	public ResponseEntity<Object> updateAllocationPercentage(int memberId, int allocationPercentage) {
		Optional<MemberInformation> memberInformation = memberInformationRepository.findById(memberId);
		if(!memberInformation.isEmpty()) {
			MemberInformation memberInfo =memberInformation.get();
			memberInfo.setAllocationPercentage(allocationPercentage);
			memberInformationRepository.save(memberInfo);			
		}else {
			throw new MemberNotFoundException();
		}
		return ResponseEntity.ok(new MessageResponse("Allocation percentage updated successfully"));
	}

}
