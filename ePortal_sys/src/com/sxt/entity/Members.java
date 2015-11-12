package com.sxt.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
 * Members entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MEMBERS", schema = "PKX")
public class Members implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Memberlevel memberlevel;
	private String loginname;
	private String loginpwd;
	private String membername;
	private String phone;
	private String address;
	private String zip;
	private Timestamp regdate;
	private Timestamp lastdate;
	private BigDecimal logintimes;
	private String email;
	private BigDecimal integral;
	private Set<Orders> orderses = new HashSet<Orders>(0);
	private Set<Cart> carts = new HashSet<Cart>(0);

	// Constructors

	/** default constructor */
	public Members() {
	}

	/** full constructor */
	public Members(Memberlevel memberlevel, String loginname, String loginpwd,
			String membername, String phone, String address, String zip,
			Timestamp regdate, Timestamp lastdate, BigDecimal logintimes,
			String email, BigDecimal integral, Set<Orders> orderses,
			Set<Cart> carts) {
		this.memberlevel = memberlevel;
		this.loginname = loginname;
		this.loginpwd = loginpwd;
		this.membername = membername;
		this.phone = phone;
		this.address = address;
		this.zip = zip;
		this.regdate = regdate;
		this.lastdate = lastdate;
		this.logintimes = logintimes;
		this.email = email;
		this.integral = integral;
		this.orderses = orderses;
		this.carts = carts;
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
	public Memberlevel getMemberlevel() {
		return this.memberlevel;
	}

	public void setMemberlevel(Memberlevel memberlevel) {
		this.memberlevel = memberlevel;
	}

	@Column(name = "LOGINNAME", length = 20)
	public String getLoginname() {
		return this.loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	@Column(name = "LOGINPWD", length = 20)
	public String getLoginpwd() {
		return this.loginpwd;
	}

	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}

	@Column(name = "MEMBERNAME", length = 20)
	public String getMembername() {
		return this.membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	@Column(name = "PHONE", length = 15)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "ADDRESS", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "ZIP", length = 12)
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "REGDATE", length = 7)
	public Timestamp getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	@Column(name = "LASTDATE", length = 7)
	public Timestamp getLastdate() {
		return this.lastdate;
	}

	public void setLastdate(Timestamp lastdate) {
		this.lastdate = lastdate;
	}

	@Column(name = "LOGINTIMES", precision = 22, scale = 0)
	public BigDecimal getLogintimes() {
		return this.logintimes;
	}

	public void setLogintimes(BigDecimal logintimes) {
		this.logintimes = logintimes;
	}

	@Column(name = "EMAIL", length = 30)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "INTEGRAL", precision = 22, scale = 0)
	public BigDecimal getIntegral() {
		return this.integral;
	}

	public void setIntegral(BigDecimal integral) {
		this.integral = integral;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "members")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "members")
	public Set<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(Set<Cart> carts) {
		this.carts = carts;
	}

}