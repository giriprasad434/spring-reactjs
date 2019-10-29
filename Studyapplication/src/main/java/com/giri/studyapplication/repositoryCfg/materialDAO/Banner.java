package com.giri.studyapplication.repositoryCfg.materialDAO;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "giri.v_banner_teplate")
public class Banner implements Serializable {
	@Id
	@Column(name = "wm_id")
	private int id;
	@Column(name = "seq_no")
	private int sno;
	@Column(name = "internal_name")
	private String internal;
	@Column(name = "display_name")
	private String display;

	public int getSno() {
		return sno;
	}

	public String getInternal() {
		return internal;
	}

	public String getDisplay() {
		return display;
	}

}
