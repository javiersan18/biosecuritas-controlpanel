package com.biosecuritas.controlpanel.db.entities;

import javax.persistence.*;
import com.biosecuritas.controlpanel.utils.AuthorityType;

@Entity
@Table(name = "authority")
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Enumerated(EnumType.STRING)
	private AuthorityType name;

	public Authority() {
	}

	public Authority(AuthorityType name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AuthorityType getName() {
		return name;
	}

	public void setName(AuthorityType name) {
		this.name = name;
	}

}
