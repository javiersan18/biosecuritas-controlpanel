package com.biosecuritas.controlpanel.db.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "client_code")
	private Integer clientCode;

	private String name;

	private String surname;

	private String address;

	@Column(name = "postal_code")
	private Integer postalCode;

	private String province;

	private String city;

	private String country;

	private String CIF;

	private String representant;

	private String DNI;

	@Column(name = "date_ini")
	@Type(type = "date")
	private Date dateIni;

	@Column(name = "date_fin")
	@Type(type = "date")
	private Date dateFin;

	private String CC;

	private Integer T;

	private String fAddress;

	@Column(name = "f_postal_code")
	private Integer fPostalCode;

	private String fProvince;

	private String fCity;

	private String fCountry;

	private Integer numC;

	private String rega;

	public Client() {
	}

	public Integer getClientCode() {
		return clientCode;
	}

	public void setClientCode(Integer clientCode) {
		this.clientCode = clientCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public String getRepresentant() {
		return representant;
	}

	public void setRepresentant(String representant) {
		this.representant = representant;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Date getDateIni() {
		return dateIni;
	}

	public void setDateIni(Date dateIni) {
		this.dateIni = dateIni;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getCC() {
		return CC;
	}

	public void setCC(String cC) {
		CC = cC;
	}

	public Integer getT() {
		return T;
	}

	public void setT(Integer t) {
		T = t;
	}

	public String getfAddress() {
		return fAddress;
	}

	public void setfAddress(String fAddress) {
		this.fAddress = fAddress;
	}

	public Integer getfPostalCode() {
		return fPostalCode;
	}

	public void setfPostalCode(Integer fPostalCode) {
		this.fPostalCode = fPostalCode;
	}

	public String getfProvince() {
		return fProvince;
	}

	public void setfProvince(String fProvince) {
		this.fProvince = fProvince;
	}

	public String getfCity() {
		return fCity;
	}

	public void setfCity(String fCity) {
		this.fCity = fCity;
	}

	public String getfCountry() {
		return fCountry;
	}

	public void setfCountry(String fCountry) {
		this.fCountry = fCountry;
	}

	public Integer getNumC() {
		return numC;
	}

	public void setNumC(Integer numC) {
		this.numC = numC;
	}

	public String getRega() {
		return rega;
	}

	public void setRega(String rega) {
		this.rega = rega;
	}

	@Override
	public String toString() {
		return "Client [clientCode=" + clientCode + ", name=" + name + ", surname=" + surname + ", address=" + address
				+ ", postalCode=" + postalCode + ", province=" + province + ", city=" + city + ", country=" + country
				+ ", CIF=" + CIF + ", representant=" + representant + ", DNI=" + DNI + ", dateIni=" + dateIni
				+ ", dateFin=" + dateFin + ", CC=" + CC + ", T=" + T + ", fAddress=" + fAddress + ", fPostalCode="
				+ fPostalCode + ", fProvince=" + fProvince + ", fCity=" + fCity + ", fCountry=" + fCountry + ", numC="
				+ numC + ", rega=" + rega + "]";
	}

}
