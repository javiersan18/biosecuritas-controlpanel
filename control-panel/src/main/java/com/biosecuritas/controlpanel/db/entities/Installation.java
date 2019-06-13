package com.biosecuritas.controlpanel.db.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.type.DateType;

@Entity
@Table(name = "installation")
public class Installation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "installation_hydrolyzer", joinColumns = {
			@JoinColumn(name = "installation_id") }, inverseJoinColumns = { @JoinColumn(name = "hydrolyzer_id") })
	private Set<Hydrolyzer> hydrolyzers = new HashSet<>();

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "installation_farm", joinColumns = {
			@JoinColumn(name = "installation_id") }, inverseJoinColumns = { @JoinColumn(name = "farm_id") })
	private Set<Farm> farms = new HashSet<>();

	@Column(name = "initial_weigth")
	private Float initialWeigth;

	@Column(name = "collected_weigth")
	private Float collectedWeigth;

	@Column(name = "delivery_date")
	private DateType deliveyDate;

	@Column(name = "seal_date")
	private DateType sealDate;

	@Column(name = "return_date")
	private DateType returnDate;

	public Installation() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Set<Hydrolyzer> getHydrolyzers() {
		return hydrolyzers;
	}

	public void setHydrolyzers(Set<Hydrolyzer> hydrolyzers) {
		this.hydrolyzers = hydrolyzers;
	}

	public Set<Farm> getFarms() {
		return farms;
	}

	public void setFarms(Set<Farm> farms) {
		this.farms = farms;
	}

	public Float getInitialWeigth() {
		return initialWeigth;
	}

	public void setInitialWeigth(Float initialWeigth) {
		this.initialWeigth = initialWeigth;
	}

	public Float getCollectedWeigth() {
		return collectedWeigth;
	}

	public void setCollectedWeigth(Float collectedWeigth) {
		this.collectedWeigth = collectedWeigth;
	}

	public DateType getDeliveyDate() {
		return deliveyDate;
	}

	public void setDeliveyDate(DateType deliveyDate) {
		this.deliveyDate = deliveyDate;
	}

	public DateType getSealDate() {
		return sealDate;
	}

	public void setSealDate(DateType sealDate) {
		this.sealDate = sealDate;
	}

	public DateType getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(DateType returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Installation [id=" + id + ", hydrolyzers=" + hydrolyzers + ", farms=" + farms + ", initialWeigth="
				+ initialWeigth + ", collectedWeigth=" + collectedWeigth + ", deliveyDate=" + deliveyDate
				+ ", sealDate=" + sealDate + ", returnDate=" + returnDate + "]";
	}

}
