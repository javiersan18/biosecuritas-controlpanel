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
@Table(name = "installation")
public class Installation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	private Client clientId;

	@ManyToOne
	private Farm farmId;

	@ManyToOne
	private Hydrolyzer hydrolyzerId;

	@Column(name = "initial_weight")
	private Float initialWeight;

	@Column(name = "collected_weight")
	private Float collectedWeight;

	@Column(name = "delivery_date")
	private Date deliveryDate;

	@Column(name = "seal_date")
	private Date sealDate;

	@Column(name = "return_date")
	private Date returnDate;

	public Installation() {
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

	public Farm getFarmId() {
		return farmId;
	}

	public void setFarmId(Farm farmId) {
		this.farmId = farmId;
	}

	public Hydrolyzer getHydrolyzerId() {
		return hydrolyzerId;
	}

	public void setHydrolyzerId(Hydrolyzer hydrolyzerId) {
		this.hydrolyzerId = hydrolyzerId;
	}

	public Float getInitialWeight() {
		return initialWeight;
	}

	public void setInitialWeight(Float initialWeight) {
		this.initialWeight = initialWeight;
	}

	public Float getCollectedWeight() {
		return collectedWeight;
	}

	public void setCollectedWeight(Float collectedWeight) {
		this.collectedWeight = collectedWeight;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getSealDate() {
		return sealDate;
	}

	public void setSealDate(Date sealDate) {
		this.sealDate = sealDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "Installation [id=" + id + ", clientId=" + clientId + ", farmId=" + farmId + ", hydrolyzerId="
				+ hydrolyzerId + ", initialWeight=" + initialWeight + ", collectedWeight=" + collectedWeight
				+ ", deliveryDate=" + deliveryDate + ", sealDate=" + sealDate + ", returnDate=" + returnDate + "]";
	}

}
