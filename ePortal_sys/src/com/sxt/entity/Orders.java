package com.sxt.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ORDERS", schema = "PKX")
public class Orders implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Members members;
	private Cart cart;
	private String orderno;
	private Timestamp orderdate;
	private BigDecimal orderstatus;

	// Constructors

	/** default constructor */
	public Orders() {
	}

	/** full constructor */
	public Orders(Members members, Cart cart, String orderno,
			Timestamp orderdate, BigDecimal orderstatus) {
		this.members = members;
		this.cart = cart;
		this.orderno = orderno;
		this.orderdate = orderdate;
		this.orderstatus = orderstatus;
	}

	// Property accessors
	@SequenceGenerator(name = "generator")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMID")
	public Members getMembers() {
		return this.members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARTID")
	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Column(name = "ORDERNO", length = 20)
	public String getOrderno() {
		return this.orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	@Column(name = "ORDERDATE", length = 7)
	public Timestamp getOrderdate() {
		return this.orderdate;
	}

	public void setOrderdate(Timestamp orderdate) {
		this.orderdate = orderdate;
	}

	@Column(name = "ORDERSTATUS", precision = 22, scale = 0)
	public BigDecimal getOrderstatus() {
		return this.orderstatus;
	}

	public void setOrderstatus(BigDecimal orderstatus) {
		this.orderstatus = orderstatus;
	}

}