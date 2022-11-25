package org.suresh.blogapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author cogjava3381
 *
 */
public class MemberInformationRequest implements Serializable{
	
	private static final long serialVersionUID = -2553497843878853259L;

	  	@NotNull
	  	private String name;
	  	
	  	@NotNull
	  	private Integer experience;
	  
	    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	  	private List<String> skillsetData;
	  	
	  	@NotNull
	  	private String additionalInfo;
	  	
	  	@NotNull
	  	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	  	private Date startDate;
	  	
	  	@NotNull
	  	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy HH:mm:ss")
	  	private Date endDate;
	  	
	  	@NotNull
	  	private int allocationPercentage;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getExperience() {
			return experience;
		}

		public void setExperience(Integer experience) {
			this.experience = experience;
		}
		
		public String getAdditionalInfo() {
			return additionalInfo;
		}

		public void setAdditionalInfo(String additionalInfo) {
			this.additionalInfo = additionalInfo;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		/**
		 * @return the skillset
		 */
		public List<String> getSkillset() {
			return skillsetData;
		}

		/**
		 * @param skillset the skillset to set
		 */
		public void setSkillset(List<String> skillsetData) {
			this.skillsetData = skillsetData;
		}

		/**
		 * @return the allocationPercentage
		 */
		public int getAllocationPercentage() {
			return allocationPercentage;
		}

		/**
		 * @param allocationPercentage the allocationPercentage to set
		 */
		public void setAllocationPercentage(int allocationPercentage) {
			this.allocationPercentage = allocationPercentage;
		}
}
