package com.eauction.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auction")
public class Auction {

	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "seller_id")
	private int seller_id;
	
	@Column(name = "buyer_id")
	private int buyer_id;
	
	@Column(name = "product_id")
	private int product_id;
	

	@Column(name = "bid_amount")
	private int bid_amount;
	
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getBid_amount() {
		return bid_amount;
	}

	public void setBid_amount(int bid_amount) {
		this.bid_amount = bid_amount;
	}

}
