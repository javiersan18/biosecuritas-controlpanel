package com.biosecuritas.controlpanel.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.type.DateType;

@Entity
@Table(name = "hydrolyzer")
public class Hydrolyzer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Client clientId;

	@Column(name = "max_weigth")
	private Float maxWeigth;

	@Column(name = "date_ini")
	private DateType dateIni;

	public Hydrolyzer() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public Float getMaxWeigth() {
		return maxWeigth;
	}

	public void setMaxWeigth(Float maxWeigth) {
		this.maxWeigth = maxWeigth;
	}

	public DateType getDateIni() {
		return dateIni;
	}

	public void setDateIni(DateType dateIni) {
		this.dateIni = dateIni;
	}

	@Override
	public String toString() {
		return "Hydrolyzer [id=" + id + ", clientId=" + clientId + ", maxWeigth=" + maxWeigth + ", dateIni=" + dateIni
				+ "]";
	}

}
