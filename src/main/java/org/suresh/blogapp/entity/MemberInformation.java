/**
 * 
 */
package org.suresh.blogapp.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author cogjava3381
 *
 */
@Entity
@Table(name = "member_information")
public class MemberInformation {
	
	  	@Id
	    @Column(name = "member_id")
	  	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	    private Integer memberId;
	  	
	  	@NotNull
	  	@Column(name = "name")
	  	private String name;
	  	
	  	@NotNull
	  	@Column(name = "experience")
	  	private Integer experience;
	  	
	  	@NotNull
	  	@Column(name = "additional_information")
	  	private String additionalInfo;
	  	
	  	@NotNull
	  	@Basic(optional = false)
	  	@Column(name = "start_date")
	  	@Temporal(TemporalType.TIMESTAMP)
	  	private Date startDate;
	  	
	  	@NotNull
		@Basic(optional = false)
	  	@Column(name= "end_date")
	  	@Temporal(TemporalType.TIMESTAMP)
	  	private Date endDate;
	  	
	  	@NotNull
	  	@Column(name= "allocation_percentage")
	  	private int allocationPercentage;

		public Integer getMemberId() {
			return memberId;
		}

		public void setMemberId(Integer memberId) {
			this.memberId = memberId;
		}

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
