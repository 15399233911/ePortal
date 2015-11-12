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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Memberlevel entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "MEMBERLEVEL", schema = "PKX")
public class Memberlevel implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private String levelname;
	private BigDecimal integral;
	private BigDecimal favourable;
	private Set<Members> memberses = new HashSet<Members>(0);

	// Constructors

	/** default constructor */
	public Memberlevel() {
	}

	/** full constructor */
	public Memberlevel(String levelname, BigDecimal integral,
			BigDecimal favourable, Set<Members> memberses) {
		this.levelname = levelname;
		this.integral = integral;
		this.favourable = favourable;
		this.memberses = memberses;
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

	@Column(name = "LEVELNAME", length = 20)
	public String getLevelname() {
		return this.levelname;
	}

	public void setLevelname(String levelname) {
		this.levelname = levelname;
	}

	@Column(name = "INTEGRAL", precision = 22, scale = 0)
	public BigDecimal getIntegral() {
		return this.integral;
	}

	public void setIntegral(BigDecimal integral) {
		this.integral = integral;
	}

	@Column(name = "FAVOURABLE", precision = 22, scale = 0)
	public BigDecimal getFavourable() {
		return this.favourable;
	}

	public void setFavourable(BigDecimal favourable) {
		this.favourable = favourable;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "memberlevel")
	public Set<Members> getMemberses() {
		return this.memberses;
	}

	public void setMemberses(Set<Members> memberses) {
		this.memberses = memberses;
	}

}