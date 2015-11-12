package com.sxt.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
 * Categorys entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "CATEGORYS", schema = "PKX")
public class Categorys implements java.io.Serializable {

	// Fields

	private int id;
	private Categorys categorys;
	private String catename;
	private List<Categorys> categoryses=new ArrayList<Categorys>();
	private Set<Merchandise> merchandises = new HashSet<Merchandise>(0);

	// Constructors

	/** default constructor */
	public Categorys() {
	}

	/** full constructor */
	public Categorys(Categorys categorys, String catename,
			List<Categorys> categoryses, Set<Merchandise> merchandises) {
		this.categorys = categorys;
		this.catename = catename;
		this.categoryses = categoryses;
		this.merchandises = merchandises;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="seq_categorys")
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENTID")
	public Categorys getCategorys() {
		return this.categorys;
	}

	public void setCategorys(Categorys categorys) {
		this.categorys = categorys;
	}

	@Column(name = "CATENAME", length = 50)
	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categorys")
	public List<Categorys> getCategoryses() {
		return this.categoryses;
	}

	public void setCategoryses(List<Categorys> categoryses) {
		this.categoryses = categoryses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categorys")
	public Set<Merchandise> getMerchandises() {
		return this.merchandises;
	}

	public void setMerchandises(Set<Merchandise> merchandises) {
		this.merchandises = merchandises;
	}

}