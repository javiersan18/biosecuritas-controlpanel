package com.biosecuritas.controlpanel.db.entities;

import java.util.Date;

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

	@Column(name = "max_weight")
	private Float maxWeight;

	@Column(name = "date_ini")
	private Date dateIni;

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

	public Float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(Float maxWeight) {
		this.maxWeight = maxWeight;
	}

	public Date getDateIni() {
		return dateIni;
	}

	public void setDateIni(Date dateIni) {
		this.dateIni = dateIni;
	}

	@Override
	public String toString() {
		return "Hydrolyzer [id=" + id + ", clientId=" + clientId + ", maxWeight=" + maxWeight + ", dateIni=" + dateIni
				+ "]";
	}

}
