package com.biosecuritas.controlpanel.db.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "farm")
public class Farm {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;

	private String REGA;

	@ManyToOne
	@Column(nullable = false)
	private Client clientId;

	@Column(name = "street_type")
	private String streetType;

	private String address;

	private String unit;

	private String province;

	private String city;

	@Column(name = "postal_code")
	private Integer postalCode;

	private String country;

	private Double latitude;

	private Double longitude;

	@ManyToMany
	private Set<Contact> contacts;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getREGA() {
		return REGA;
	}

	public void setREGA(String rEGA) {
		REGA = rEGA;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public String getNumSandach() {
		return numSandach;
	}

	public void setNumSandach(String numSandach) {
		this.numSandach = numSandach;
	}

	@Override
	public String toString() {
		return "Farm [id=" + id + ", name=" + name + ", REGA=" + REGA + ", clientId=" + clientId + ", streetType="
				+ streetType + ", address=" + address + ", unit=" + unit + ", province=" + province + ", city=" + city
				+ ", postalCode=" + postalCode + ", country=" + country + ", latitude=" + latitude + ", longitude="
				+ longitude + ", contacts=" + contacts + ", numSandach=" + numSandach + "]";
	}

}
