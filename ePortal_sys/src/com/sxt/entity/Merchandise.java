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
 * Merchandise entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MERCHANDISE", schema = "PKX")
public class Merchandise implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Categorys categorys;
	private String mername;
	private BigDecimal price;
	private BigDecimal sprice;
	private String mermodel;
	private String picture;
	private String video;
	private String merdesc;
	private String manufacturer;
	private Timestamp factorydate;
	private BigDecimal special;
	private String htmlpath;
	private BigDecimal status;
	private Set<Cartselectedmer> cartselectedmers = new HashSet<Cartselectedmer>(
			0);

	// Constructors

	/** default constructor */
	public Merchandise() {
	}

	/** full constructor */
	public Merchandise(Categorys categorys, String mername, BigDecimal price,
			BigDecimal sprice, String mermodel, String picture, String video,
			String merdesc, String manufacturer, Timestamp factorydate,
			BigDecimal special, String htmlpath, BigDecimal status,
			Set<Cartselectedmer> cartselectedmers) {
		this.categorys = categorys;
		this.mername = mername;
		this.price = price;
		this.sprice = sprice;
		this.mermodel = mermodel;
		this.picture = picture;
		this.video = video;
		this.merdesc = merdesc;
		this.manufacturer = manufacturer;
		this.factorydate = factorydate;
		this.special = special;
		this.htmlpath = htmlpath;
		this.status = status;
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
	@JoinColumn(name = "CATEID")
	public Categorys getCategorys() {
		return this.categorys;
	}

	public void setCategorys(Categorys categorys) {
		this.categorys = categorys;
	}

	@Column(name = "MERNAME", length = 50)
	public String getMername() {
		return this.mername;
	}

	public void setMername(String mername) {
		this.mername = mername;
	}

	@Column(name = "PRICE", precision = 22, scale = 0)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "SPRICE", precision = 22, scale = 0)
	public BigDecimal getSprice() {
		return this.sprice;
	}

	public void setSprice(BigDecimal sprice) {
		this.sprice = sprice;
	}

	@Column(name = "MERMODEL", length = 20)
	public String getMermodel() {
		return this.mermodel;
	}

	public void setMermodel(String mermodel) {
		this.mermodel = mermodel;
	}

	@Column(name = "PICTURE", length = 20)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "VIDEO", length = 20)
	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Column(name = "MERDESC", length = 100)
	public String getMerdesc() {
		return this.merdesc;
	}

	public void setMerdesc(String merdesc) {
		this.merdesc = merdesc;
	}

	@Column(name = "MANUFACTURER", length = 50)
	public String getManufacturer() {
		return this.manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Column(name = "FACTORYDATE", length = 7)
	public Timestamp getFactorydate() {
		return this.factorydate;
	}

	public void setFactorydate(Timestamp factorydate) {
		this.factorydate = factorydate;
	}

	@Column(name = "SPECIAL", precision = 22, scale = 0)
	public BigDecimal getSpecial() {
		return this.special;
	}

	public void setSpecial(BigDecimal special) {
		this.special = special;
	}

	@Column(name = "HTMLPATH", length = 30)
	public String getHtmlpath() {
		return this.htmlpath;
	}

	public void setHtmlpath(String htmlpath) {
		this.htmlpath = htmlpath;
	}

	@Column(name = "STATUS", precision = 22, scale = 0)
	public BigDecimal getStatus() {
		return this.status;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "merchandise")
	public Set<Cartselectedmer> getCartselectedmers() {
		return this.cartselectedmers;
	}

	public void setCartselectedmers(Set<Cartselectedmer> cartselectedmers) {
		this.cartselectedmers = cartselectedmers;
	}

}