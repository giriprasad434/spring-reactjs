package com.giri.studyapplication.repositoryCfg.materialDAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService {

	public BannerService() {
		super();
	}

	private SessionFactory sessionFactory;

	@Autowired
	public BannerService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<?> getBannerNames() {
		return this.sessionFactory.openSession()
				.createSQLQuery("SELECT  wm_id,  seq_no,  internal_name,display_name FROM public.v_banner_teplate")
				.addEntity(Banner.class).getResultList();
	}

}
