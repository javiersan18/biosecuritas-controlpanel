package com.biosecuritas.controlpanel.db.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String CIF;

	@Column(nullable = false, name = "rep_name")
	private String repName;

	@Column(name = "rep_surname_1")
	private String repSurname1;

	@Column(name = "rep_surname_2")
	private String repSurname2;

	private String DNI;

	@Column(name = "bank_account")
	private String bankAccount;

	@Column(name = "date_agreement_begin")
	@Type(type = "date")
	private Date dateAgreementBegin;

	@Column(name = "date_agreement_end")
	@Type(type = "date")
	private Date dateAgreementEnd;

	@Column(name = "agreement_durantion")
	private Integer agreementDuration;

	@Column(name = "agreement_type")
	private String agreementType;

	@Column(name = "street_type")
	private String streetType;

	@Column(name = "fiscal_address")
	private String fiscalAddress;

	private String unit;

	@Column(name = "postal_code")
	private Integer postalCode;

	private String province;

	private String city;

	private String country;

	@Transient
	private Integer numHydros;

	@Transient
	private Integer numFarms;

	public Client() {
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

	public String getCIF() {
		return CIF;
	}

	public void setCIF(String cIF) {
		CIF = cIF;
	}

	public String getRepName() {
		return repName;
	}

	public void setRepName(String repName) {
		this.repName = repName;
	}

	public String getRepSurname1() {
		return repSurname1;
	}

	public void setRepSurname1(String repSurname1) {
		this.repSurname1 = repSurname1;
	}

	public String getRepSurname2() {
		return repSurname2;
	}

	public void setRepSurname2(String repSurname2) {
		this.repSurname2 = repSurname2;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Date getDateAgreementBegin() {
		return dateAgreementBegin;
	}

	public void setDateAgreementBegin(Date dateAgreementBegin) {
		this.dateAgreementBegin = dateAgreementBegin;
	}

	public Date getDateAgreementEnd() {
		return dateAgreementEnd;
	}

	public void setDateAgreementEnd(Date dateAgreementEnd) {
		this.dateAgreementEnd = dateAgreementEnd;
	}

	public Integer getAgreementDuration() {
		return agreementDuration;
	}

	public void setAgreementDuration(Integer agreementDuration) {
		this.agreementDuration = agreementDuration;
	}

	public String getAgreementType() {
		return agreementType;
	}

	public void setAgreementType(String agreementType) {
		this.agreementType = agreementType;
	}

	public String getStreetType() {
		return streetType;
	}

	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}

	public String getFiscalAddress() {
		return fiscalAddress;
	}

	public void setFiscalAddress(String fiscalAddress) {
		this.fiscalAddress = fiscalAddress;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public Integer getNumHydros() {
		return numHydros;
	}

	public void setNumHydros(Integer numHydros) {
		this.numHydros = numHydros;
	}

	public Integer getNumFarms() {
		return numFarms;
	}

	public void setNumFarms(Integer numFarms) {
		this.numFarms = numFarms;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", CIF=" + CIF + ", repName=" + repName + ", repSurname1="
				+ repSurname1 + ", repSurname2=" + repSurname2 + ", DNI=" + DNI + ", bankAccount=" + bankAccount
				+ ", dateAgreementBegin=" + dateAgreementBegin + ", dateAgreementEnd=" + dateAgreementEnd
				+ ", agreementDuration=" + agreementDuration + ", agreementType=" + agreementType + ", streetType="
				+ streetType + ", fiscalAddress=" + fiscalAddress + ", unit=" + unit + ", postalCode=" + postalCode
				+ ", province=" + province + ", city=" + city + ", country=" + country + ", numHydros=" + numHydros
				+ ", numFarms=" + numFarms + "]";
	}

}
