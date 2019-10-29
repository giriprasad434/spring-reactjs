package com.giri.studyapplication.repositoryCfg.materialDAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaterialsService {
	@Autowired
	private SessionFactory sessionFactory;

	public MaterialsService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public MaterialsService() {
		super();
	}


	public List<?> getMaterial() {
		List<?> li=null;
		try {
			li=this.sessionFactory.openSession().createSQLQuery("select *from material").addEntity(Material.class).getResultList();
		} catch (Exception e) {
			li=null;
		}
			return li;
		
		
		
	}
}
