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
 * Newscolumns entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "NEWSCOLUMNS", schema = "PKX")
public class Newscolumns implements java.io.Serializable {

	// Fields

	private int id;
	private Newscolumns newscolumns;
	private String columncode;
	private String columnname;
	private List<News> newses = new ArrayList<News>(0);
	private Set<Newscolumns> newscolumnses = new HashSet<Newscolumns>(0);

	// Constructors

	/** default constructor */
	public Newscolumns() {
	}

	/** full constructor */
	public Newscolumns(Newscolumns newscolumns, String columncode,
			String columnname, List<News> newses, Set<Newscolumns> newscolumnses) {
		this.newscolumns = newscolumns;
		this.columncode = columncode;
		this.columnname = columnname;
		this.newses = newses;
		this.newscolumnses = newscolumnses;
	}

	// Property accessors
	@SequenceGenerator(name = "generator",sequenceName="seq_newscolumns")
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
	public Newscolumns getNewscolumns() {
		return this.newscolumns;
	}

	public void setNewscolumns(Newscolumns newscolumns) {
		this.newscolumns = newscolumns;
	}

	@Column(name = "COLUMNCODE", length = 20)
	public String getColumncode() {
		return this.columncode;
	}

	public void setColumncode(String columncode) {
		this.columncode = columncode;
	}

	@Column(name = "COLUMNNAME", length = 50)
	public String getColumnname() {
		return this.columnname;
	}

	public void setColumnname(String columnname) {
		this.columnname = columnname;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "newscolumns")
	public List<News> getNewses() {
		return this.newses;
	}

	public void setNewses(List<News> newses) {
		this.newses = newses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "newscolumns")
	public Set<Newscolumns> getNewscolumnses() {
		return this.newscolumnses;
	}

	public void setNewscolumnses(Set<Newscolumns> newscolumnses) {
		this.newscolumnses = newscolumnses;
	}

}