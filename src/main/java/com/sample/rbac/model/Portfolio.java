/**
 * 
 */
package com.sample.rbac.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author NishigandhaomanwarOm
 *
 */

@Entity
@Table(name = "PORTFOLIO", schema="prototypemora")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@SequenceGenerator(name="PORTFOLIO_ID_GENERATOR", sequenceName="prototypemora.PORTFOLIO_SEQ")
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PORTFOLIO_ID_GENERATOR")
	@Column(name = "ID")
	private Long id;
	@Column(name = "RAR_ID")
	private Long rarId;
	@Column(name = "PORTFOLIO_Name")
	private String name;
	@Column(name = "portfolio_code")
	private String portfolioCode;
	@Column(name = "CURRENCY")
	private String currency;
	@Column(name = "VALID_FROM")
	private Date validFrom;
	@Column(name = "VALID_TO")
	private Date validTo;
	@Column(name = "ACTIVE")
	private String active;
	@Column(name = "DESCRIPTION")
	private String description;
//	@Version
//	@Column(name = "VERSION")
//	private Integer version;
	
	@Transient
	private List<Portfolio> children;
	
	@Transient
	private Long parentId;

	public Portfolio() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRarId() {
		return rarId;
	}

	public void setRarId(Long rarId) {
		this.rarId = rarId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPortfolioCode() {
		return portfolioCode;
	}

	public void setPortfolioCode(String portfolioCode) {
		this.portfolioCode = portfolioCode;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Integer getVersion() {
//		return version;
//	}
//
//	public void setVersion(Integer version) {
//		this.version = version;
//	}

	public List<Portfolio> getChildren() {
		return children;
	}

	public void setChildren(List<Portfolio> children) {
		this.children = children;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	
}
