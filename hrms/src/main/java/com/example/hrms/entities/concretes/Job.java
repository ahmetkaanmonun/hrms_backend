package com.example.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "jobs")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement"})

public class Job {
	
	
	
	@Id @Column(name = "id") @GeneratedValue
	private int id;
	
	
	@Column(name = "job_title") 
	private String job;
	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "job")
	private List<JobAdvertisement> jobAdvertisement;
	
	
	
	

}
