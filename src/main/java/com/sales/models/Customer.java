//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //


package com.sales.models;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CUSTOMERS")
public class Customer {
	@Id
	@Column(name="CID")
	private Long cId;

	@NotEmpty(message = "Please enter your Name")
	@Column(name="CNAME")
	private String cName;
	
	@NotNull(message = "Please enter your Loan Period")
	@Column(name="LOANPERIOD")
	@Min(value=1)
	private Long loanPeriod;
	
	@OneToMany(mappedBy="cust")
	private List<Loan> loans = new ArrayList<Loan>();

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public Long getLoanPeriod() {
		return loanPeriod;
	}

	public void setLoanPeriod(Long loanPeriod) {
		this.loanPeriod = loanPeriod;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

}