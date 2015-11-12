package com.sxt.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Cart entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CART", schema = "PKX")
public class Cart implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Members members;
	private BigDecimal money;
	private BigDecimal cartstatus;
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Cartselectedmer> cartselectedmers = new HashSet<Cartselectedmer>(
			0);

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** full constructor */
	public Cart(Members members, BigDecimal money, BigDecimal cartstatus,
			Set<Orders> orderses, Set<Cartselectedmer> cartselectedmers) {
		this.members = members;
		this.money = money;
		this.cartstatus = cartstatus;
		this.orderses = orderses;
		this.cartselectedmers = cartselectedmers;
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

	@Column(name = "MONEY", precision = 22, scale = 0)
	public BigDecimal getMoney() {
		return this.money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	@Column(name = "CARTSTATUS", precision = 22, scale = 0)
	public BigDecimal getCartstatus() {
		return this.cartstatus;
	}

	public void setCartstatus(BigDecimal cartstatus) {
		this.cartstatus = cartstatus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cart")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cart")
	public Set<Cartselectedmer> getCartselectedmers() {
		return this.cartselectedmers;
	}

	public void setCartselectedmers(Set<Cartselectedmer> cartselectedmers) {
		this.cartselectedmers = cartselectedmers;
	}

}