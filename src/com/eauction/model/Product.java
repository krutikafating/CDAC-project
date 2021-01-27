package com.eauction.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.mysql.cj.jdbc.Blob;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "id")
	private int id;
	
    @ManyToOne
    @JoinColumn(name="seller_id", referencedColumnName="id")
    User seller;
	
	@Column(name = "product_name")
	private String product_name;
	
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
	
//	@Lob
//	@Basic(fetch = FetchType.LAZY)
//	@Column(columnDefinition = "BLOB NOT NULL")
//	private byte[] image;
//
//	

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}


	

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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
	
//	public byte[] getImage() {
//		return image;
//	}
//
//	public void setImage(byte[] image) {
//		this.image = image;
//	}
}
