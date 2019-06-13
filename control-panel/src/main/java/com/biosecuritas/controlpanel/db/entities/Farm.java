package com.biosecuritas.controlpanel.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farm")
public class Farm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Client clientId;

	private String address;

	@Column(name = "postal_code")
	private Integer postalCode;

	private String province;

	private String city;

	private String country;

	private String prefix;

	@Column(name = "contact_phone")
	private Integer contactPhone;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "num_sandach")
	private String numSandach;

	public Farm() {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public Integer getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(Integer contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getNumSandach() {
		return numSandach;
	}

	public void setNumSandach(String numSandach) {
		this.numSandach = numSandach;
	}

	@Override
	public String toString() {
		return "Farm [id=" + id + ", clientId=" + clientId + ", address=" + address + ", postalCode=" + postalCode
				+ ", province=" + province + ", city=" + city + ", country=" + country + ", prefix=" + prefix
				+ ", contactPhone=" + contactPhone + ", contactName=" + contactName + ", numSandach=" + numSandach
				+ "]";
	}

}
