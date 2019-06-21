package com.biosecuritas.controlpanel.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.biosecuritas.controlpanel.utils.InstallationStatus;

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

	@Column(name = "collected_weight")
	private Float collectedWeight;

	@Column(name = "delivery_date")
	private Date deliveryDate;

	@Column(name = "seal_date")
	private Date sealDate;

	@Column(name = "collected_date")
	private Date collectedDate;

	@Column(name = "finished_date")
	private Date finishedDate;

	@Enumerated(EnumType.STRING)
	private InstallationStatus status = InstallationStatus.ACTIVE;

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

	public Date getCollectedDate() {
		return collectedDate;
	}

	public void setCollectedDate(Date collectedDate) {
		this.collectedDate = collectedDate;
	}

	public Date getFinishedDate() {
		return finishedDate;
	}

	public void setFinishedDate(Date finishedDate) {
		this.finishedDate = finishedDate;
	}

	public InstallationStatus getStatus() {
		return status;
	}

	public void setStatus(InstallationStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Installation [id=" + id + ", clientId=" + clientId + ", farmId=" + farmId + ", hydrolyzerId="
				+ hydrolyzerId + ", collectedWeight=" + collectedWeight + ", deliveryDate=" + deliveryDate
				+ ", sealDate=" + sealDate + ", collectedDate=" + collectedDate + ", finishedDate=" + finishedDate
				+ ", status=" + status + "]";
	}

}
