package com.eauction.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.mysql.cj.jdbc.Blob;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "seller_id")
	private int seller_id;
	
	@Column(name = "buyer_id")
	private int buyer_id;
	
	@Column(name = "product")
	private String product;
	
	@Column(name = "details")
	private String details;
	
	@Column(name = "minimum_bid")
	private int minimum_bid;
	
	@Column(name = "opening_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date opening_date;
	




	@Column(name = "closing_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date closing_date;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "mobile")
	private String mobile;

	@Column(name = "status")
	private String status;
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	
	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getminimum_bid() {
		return minimum_bid;
	}

	public void setminimum_bid(int minimum_bid) {
		this.minimum_bid = minimum_bid;
	}

	public Date getOpening_date() {
		return opening_date;
	}

	public void setOpening_date(Date opening_date) {
		this.opening_date = opening_date;
	}

	public Date getClosing_date() {
		return closing_date;
	}

	public void setClosing_date(Date closing_date) {
		this.closing_date = closing_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
