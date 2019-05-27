package com.ib.poc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Message {

	@Id
	private long id;
	
	@Column(columnDefinition="TEXT")
	private String message;
	
	private String truth;
	
	private String cube;
	
	private String google;
	
	private double googleSpam;
	
	private double googleNotSpam;
	
	private String ibm;
	
	private double ibmSpam;
	
	private double ibmNotSpam;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTruth() {
		return truth;
	}

	public void setTruth(String truth) {
		this.truth = truth;
	}

	public String getCube() {
		return cube;
	}

	public void setCube(String cube) {
		this.cube = cube;
	}

	public String getGoogle() {
		return google;
	}

	public void setGoogle(String google) {
		this.google = google;
	}

	public double getGoogleSpam() {
		return googleSpam;
	}

	public void setGoogleSpam(double googleSpam) {
		this.googleSpam = googleSpam;
	}

	public double getGoogleNotSpam() {
		return googleNotSpam;
	}

	public void setGoogleNotSpam(double googleNotSpam) {
		this.googleNotSpam = googleNotSpam;
	}

	public String getIbm() {
		return ibm;
	}

	public void setIbm(String ibm) {
		this.ibm = ibm;
	}

	public double getIbmSpam() {
		return ibmSpam;
	}

	public void setIbmSpam(double ibmSpam) {
		this.ibmSpam = ibmSpam;
	}

	public double getIbmNotSpam() {
		return ibmNotSpam;
	}

	public void setIbmNotSpam(double ibmNotSpam) {
		this.ibmNotSpam = ibmNotSpam;
	}
}
