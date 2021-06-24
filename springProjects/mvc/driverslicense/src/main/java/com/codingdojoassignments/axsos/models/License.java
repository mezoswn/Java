package com.codingdojoassignments.axsos.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "licenses")
public class License {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String number;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationDate;

	@NotNull
	private String state;
	
	@Column(updatable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "driver_id"	)
	private Driver driver;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void updatedAt() {
		this.updatedAt = new Date();
	}

	public License() {
		
	}

	public License(String number, @NotNull Date expirationDate, @NotNull String state, Driver driver) {
		super();
		this.number = number;
		this.expirationDate = expirationDate;
		this.state = state;
		this.driver = driver;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	@PostPersist
	public void idGen() {
		
		String idString = Long.toString(id);
		
		switch (idString.length()) {
		case 1: {
			this.number = "00000" + idString;
			break;
		}
		case 2: {
			this.number = "0000" + idString;
			break;
		}
		case 3: {
			this.number = "000" + idString;
			break;
		}
		case 4: {
			this.number = "00" + idString;
			break;
		}
		case 5: {
			this.number = "0" + idString;
			break;
		}
		case 6: {
			this.number = idString;
			break;
		}
		default:
			this.number = "it broke";
		}		
	}
	
}
