//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //


package com.sales.models;

import javax.persistence.*;

@Entity
@Table(name="LOANS")
public class Loan {
	@Id
	@Column(name="LID")
	private Long lid;
	
	@ManyToOne
	@JoinColumn(name="BID", unique=true)
	private Book book;

	@ManyToOne
	@JoinColumn(name="CID")
	private Customer cust;
	
	
	@Column(name="DUEDATE")
	private String dueDate;


	public Long getLid() {
		return lid;
	}


	public void setLid(Long lid) {
		this.lid = lid;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public Customer getCust() {
		return cust;
	}


	public void setCust(Customer cust) {
		this.cust = cust;
	}


	public String getDueDate() {
		return dueDate;
	}


	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

}
