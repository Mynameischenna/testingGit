package com.example.firstt;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class PlanInfo {

    @Id
    private String evId;
    private String planName;
    private String irsrlCode;
    private String provCompany;
    private String prodId;
    private String statusCode;
    private String dpDateTime;
    private String rolloverInd;
    private String gaId;
    private String clientName;
    private String firstLineMailing;
    private String scndLineMailing;
    private String city;
    private String stateCode;
    private String zipCode;
    private String country;
    private String internalComplianceInd;
    private String planAnnivDate;
    private int estNumberOfParticipants;
    private long estPlanAssets;
    private LocalDate estImplementationDate;
    private String subsetCashCode;
    private String clientEntityType;
    private String tpaFirmId;
	
    
    
    public String getEvId() {
        return evId;
    }

    public void setEvId(String evId) {
        this.evId = evId;
    }
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getIrsrlCode() {
		return irsrlCode;
	}
	public void setIrsrlCode(String irsrlCode) {
		this.irsrlCode = irsrlCode;
	}
	public String getProvCompany() {
		return provCompany;
	}
	public void setProvCompany(String provCompany) {
		this.provCompany = provCompany;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getDpDateTime() {
		return dpDateTime;
	}
	public void setDpDateTime(String dpDateTime) {
		this.dpDateTime = dpDateTime;
	}
	public String getRolloverInd() {
		return rolloverInd;
	}
	public void setRolloverInd(String rolloverInd) {
		this.rolloverInd = rolloverInd;
	}
	public String getGaId() {
		return gaId;
	}
	public void setGaId(String gaId) {
		this.gaId = gaId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getFirstLineMailing() {
		return firstLineMailing;
	}
	public void setFirstLineMailing(String firstLineMailing) {
		this.firstLineMailing = firstLineMailing;
	}
	public String getScndLineMailing() {
		return scndLineMailing;
	}
	public void setScndLineMailing(String scndLineMailing) {
		this.scndLineMailing = scndLineMailing;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateCode() {
		return stateCode;
	}
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getInternalComplianceInd() {
		return internalComplianceInd;
	}
	public void setInternalComplianceInd(String internalComplianceInd) {
		this.internalComplianceInd = internalComplianceInd;
	}
	public String getPlanAnnivDate() {
		return planAnnivDate;
	}
	public void setPlanAnnivDate(String planAnnivDate) {
		this.planAnnivDate = planAnnivDate;
	}
	public int getEstNumberOfParticipants() {
		return estNumberOfParticipants;
	}
	public void setEstNumberOfParticipants(int estNumberOfParticipants) {
		this.estNumberOfParticipants = estNumberOfParticipants;
	}
	public long getEstPlanAssets() {
		return estPlanAssets;
	}
	public void setEstPlanAssets(long estPlanAssets) {
		this.estPlanAssets = estPlanAssets;
	}
	public LocalDate getEstImplementationDate() {
		return estImplementationDate;
	}
	public void setEstImplementationDate(LocalDate estImplementationDate) {
		this.estImplementationDate = estImplementationDate;
	}
	public String getSubsetCashCode() {
		return subsetCashCode;
	}
	public void setSubsetCashCode(String subsetCashCode) {
		this.subsetCashCode = subsetCashCode;
	}
	public String getClientEntityType() {
		return clientEntityType;
	}
	public void setClientEntityType(String clientEntityType) {
		this.clientEntityType = clientEntityType;
	}
	public String getTpaFirmId() {
		return tpaFirmId;
	}
	public void setTpaFirmId(String tpaFirmId) {
		this.tpaFirmId = tpaFirmId;
	}
	@Override
	public String toString() {
		return "PlanInfo [ evId=" + evId + ", planName=" + planName + ", irsrlCode=" + irsrlCode
				+ ", provCompany=" + provCompany + ", prodId=" + prodId + ", statusCode=" + statusCode + ", dpDateTime="
				+ dpDateTime + ", rolloverInd=" + rolloverInd + ", gaId=" + gaId + ", clientName=" + clientName
				+ ", firstLineMailing=" + firstLineMailing + ", scndLineMailing=" + scndLineMailing + ", city=" + city
				+ ", stateCode=" + stateCode + ", zipCode=" + zipCode + ", country=" + country
				+ ", internalComplianceInd=" + internalComplianceInd + ", planAnnivDate=" + planAnnivDate
				+ ", estNumberOfParticipants=" + estNumberOfParticipants + ", estPlanAssets=" + estPlanAssets
				+ ", estImplementationDate=" + estImplementationDate + ", subsetCashCode=" + subsetCashCode
				+ ", clientEntityType=" + clientEntityType + ", tpaFirmId=" + tpaFirmId + "]";
	}

    // Constructors, getters, setters...
    
}
