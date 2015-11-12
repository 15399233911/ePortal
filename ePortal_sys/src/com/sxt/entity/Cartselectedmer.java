package com.sxt.entity;

import java.math.BigDecimal;
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
 * Cartselectedmer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CARTSELECTEDMER", schema = "PKX")
public class Cartselectedmer implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Merchandise merchandise;
	private Cart cart;
	private BigDecimal counts;
	private Double price;
	private Double money;

	// Constructors

	/** default constructor */
	public Cartselectedmer() {
	}

	/** full constructor */
	public Cartselectedmer(Merchandise merchandise, Cart cart,
			BigDecimal counts, Double price, Double money) {
		this.merchandise = merchandise;
		this.cart = cart;
		this.counts = counts;
		this.price = price;
		this.money = money;
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
	@JoinColumn(name = "MERID")
	public Merchandise getMerchandise() {
		return this.merchandise;
	}

	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CARTID")
	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Column(name = "COUNTS", precision = 22, scale = 0)
	public BigDecimal getCounts() {
		return this.counts;
	}

	public void setCounts(BigDecimal counts) {
		this.counts = counts;
	}

	@Column(name = "PRICE", precision = 8)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "MONEY", precision = 8)
	public Double getMoney() {
		return this.money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

}