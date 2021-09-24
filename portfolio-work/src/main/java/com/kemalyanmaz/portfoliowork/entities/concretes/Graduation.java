package com.kemalyanmaz.portfoliowork.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="graduations")
public class Graduation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="graduation_name")
	private String graduationName;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGraduationName() {
		return graduationName;
	}

	public void setGraduationName(String graduationName) {
		this.graduationName = graduationName;
	}

	
	
}
