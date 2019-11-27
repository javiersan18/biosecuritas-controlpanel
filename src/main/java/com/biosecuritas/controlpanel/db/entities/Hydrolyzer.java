package com.biosecuritas.controlpanel.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hydrolyzer")
public class Hydrolyzer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, name = "serial_code")
	private String serialCode;

	@ManyToOne
	private Farm farmId;

	@Column(nullable = false, name = "hydro_weight")
	private Float hydroWeight;

	@Column(name = "max_weight")
	private Float maxWeight;

	@Column(nullable = false, name = "date")
	private Date date;

	public Hydrolyzer() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSerialCode() {
		return serialCode;
	}

	public void setSerialCode(String serialCode) {
		this.serialCode = serialCode;
	}

	public Farm getFarmId() {
		return farmId;
	}

	public void setFarmId(Farm farmId) {
		this.farmId = farmId;
	}

	public Float getHydroWeight() {
		return hydroWeight;
	}

	public void setHydroWeight(Float hydroWeight) {
		this.hydroWeight = hydroWeight;
	}

	public Float getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(Float maxWeight) {
		this.maxWeight = maxWeight;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Hydrolyzer [id=" + id + ", serialCode=" + serialCode + ", farmId=" + farmId + ", hydroWeight="
				+ hydroWeight + ", maxWeight=" + maxWeight + ", date=" + date + "]";
	}

}
