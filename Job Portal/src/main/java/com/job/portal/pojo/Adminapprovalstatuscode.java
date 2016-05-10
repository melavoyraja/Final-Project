package com.job.portal.pojo;
// Generated Apr 4, 2016 11:54:04 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Adminapprovalstatuscode generated by hbm2java
 */
@Entity
@Table(name = "adminapprovalstatuscode", catalog = "jobportal")
public class Adminapprovalstatuscode implements java.io.Serializable {

	private Integer statusId;
	private String status;
	private Set<Employer> employers = new HashSet<Employer>(0);

	public Adminapprovalstatuscode() {
	}

	public Adminapprovalstatuscode(String status) {
		this.status = status;
	}

	public Adminapprovalstatuscode(String status, Set<Employer> employers) {
		this.status = status;
		this.employers = employers;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "statusID", unique = true, nullable = false)
	public Integer getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	@Column(name = "status", nullable = false, length = 100)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "adminapprovalstatuscode")
	public Set<Employer> getEmployers() {
		return this.employers;
	}

	public void setEmployers(Set<Employer> employers) {
		this.employers = employers;
	}

}
