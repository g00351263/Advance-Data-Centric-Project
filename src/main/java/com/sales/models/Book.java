//Author Raja Naseer Ahmed Khan G00351263, Data Centric 2019 Project //
/*
 Models:
------
DB tables models are
   - Book
   - Customer
   - Loan 

There are some other models for various tasks including
   - Customer View
   - Loan View
   - New Loan Model
   - Save Result
   - MaxID
 */

package com.sales.models;

import org.hibernate.validator.constraints.*;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="BOOKS")
public class Book {
	@Id
	@Column(name="BID")
	private Long bid;
		
	@NotEmpty(message = "Please enter your Title")
	@Column(name="TITLE")
	private String title;
		
	@NotEmpty(message = "Please enter your Title")
	@Column(name="AUTHOR")
	private String author;

	
	@OneToMany(mappedBy="book")
	private List<Loan> loans = new ArrayList<Loan>();


	public Long getBid() {
		return bid;
	}


	public void setBid(Long bid) {
		this.bid = bid;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public List<Loan> getLoans() {
		return loans;
	}


	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}
	
}