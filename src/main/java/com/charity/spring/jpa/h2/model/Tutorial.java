package com.charity.spring.jpa.h2.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "cmaps")
public class Tutorial {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "title")
	private String title;

	@Column(name = "category")
	private String category;

	@Column(name = "description", columnDefinition = "LONGTEXT")
	private String description;

	@Column(name = "picture", columnDefinition = "LONGTEXT")
	private String picture;

	@Column(name = "address")
	private String address;

	@Column(name = "link")
	private String link;

	@Column(name = "phone")
	private String phone;

	@Column(name = "coords1")
	private double coords1;

	@Column(name = "coords2")
	private double coords2;

	@Column(name = "cost")
	private Integer cost;

	public Tutorial() {
		super();
	}

	public Tutorial(long id, String title, String category, String description, String address, String link, double coords1, double coords2, String phone, String picture, Integer cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.description = description;
		this.address = address;
		this.link = link;
		this.coords1 = coords1;
		this.coords2 = coords2;
		this.phone = phone;
		this.picture = picture;
		this.cost = cost;
	}

	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
			this.picture = picture;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getCoords1() {
		return coords1;
	}

	public void setCoords1(double coords1) {
		this.coords1 = coords1;
	}

	public double getCoords2() {
		return coords2;
	}

	public void setCoords2(double coords2) {
		this.coords2 = coords2;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Cmap [id=" + id + ", title=" + title + ", desc=" + description + ", address=" + address + "]";
	}

}
