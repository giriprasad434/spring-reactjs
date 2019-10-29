package com.giri.studyapplication.repositoryCfg.materialDAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material")
class Material {
	@Id
	private int id;
	@Column(name = "name")
	private String name;
	public Material(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Material() {
		super();
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
