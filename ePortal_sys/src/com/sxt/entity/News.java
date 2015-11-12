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
 * News entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "NEWS", schema = "PKX")
public class News implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private Newscolumns newscolumns;
	private String title;
	private String content;
	private String abstract_;
	private String keywords;
	private BigDecimal ispicnews;
	private String picture;
	private String newsfrom;
	private Timestamp cdate;
	private String author;
	private String editor;
	private BigDecimal clicks;
	private BigDecimal newstype;
	private BigDecimal priority;
	private BigDecimal red;
	private String htmlpath;
	private BigDecimal status;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** full constructor */
	public News(Newscolumns newscolumns, String title, String content,
			String abstract_, String keywords, BigDecimal ispicnews,
			String picture, String newsfrom, Timestamp cdate, String author,
			String editor, BigDecimal clicks, BigDecimal newstype,
			BigDecimal priority, BigDecimal red, String htmlpath,
			BigDecimal status) {
		this.newscolumns = newscolumns;
		this.title = title;
		this.content = content;
		this.abstract_ = abstract_;
		this.keywords = keywords;
		this.ispicnews = ispicnews;
		this.picture = picture;
		this.newsfrom = newsfrom;
		this.cdate = cdate;
		this.author = author;
		this.editor = editor;
		this.clicks = clicks;
		this.newstype = newstype;
		this.priority = priority;
		this.red = red;
		this.htmlpath = htmlpath;
		this.status = status;
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
	@JoinColumn(name = "CID")
	public Newscolumns getNewscolumns() {
		return this.newscolumns;
	}

	public void setNewscolumns(Newscolumns newscolumns) {
		this.newscolumns = newscolumns;
	}

	@Column(name = "TITLE", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "CONTENT", length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "ABSTRACT", length = 50)
	public String getAbstract_() {
		return this.abstract_;
	}

	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	@Column(name = "KEYWORDS", length = 20)
	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Column(name = "ISPICNEWS", precision = 22, scale = 0)
	public BigDecimal getIspicnews() {
		return this.ispicnews;
	}

	public void setIspicnews(BigDecimal ispicnews) {
		this.ispicnews = ispicnews;
	}

	@Column(name = "PICTURE", length = 50)
	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	@Column(name = "NEWSFROM", length = 30)
	public String getNewsfrom() {
		return this.newsfrom;
	}

	public void setNewsfrom(String newsfrom) {
		this.newsfrom = newsfrom;
	}

	@Column(name = "CDATE", length = 7)
	public Timestamp getCdate() {
		return this.cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

	@Column(name = "AUTHOR", length = 20)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "EDITOR", length = 20)
	public String getEditor() {
		return this.editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	@Column(name = "CLICKS", precision = 22, scale = 0)
	public BigDecimal getClicks() {
		return this.clicks;
	}

	public void setClicks(BigDecimal clicks) {
		this.clicks = clicks;
	}

	@Column(name = "NEWSTYPE", precision = 22, scale = 0)
	public BigDecimal getNewstype() {
		return this.newstype;
	}

	public void setNewstype(BigDecimal newstype) {
		this.newstype = newstype;
	}

	@Column(name = "PRIORITY", precision = 22, scale = 0)
	public BigDecimal getPriority() {
		return this.priority;
	}

	public void setPriority(BigDecimal priority) {
		this.priority = priority;
	}

	@Column(name = "RED", precision = 22, scale = 0)
	public BigDecimal getRed() {
		return this.red;
	}

	public void setRed(BigDecimal red) {
		this.red = red;
	}

	@Column(name = "HTMLPATH", length = 100)
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

}