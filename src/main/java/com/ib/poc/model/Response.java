package com.ib.poc.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value=Include.NON_NULL)
public class Response implements Serializable {
	
	
	@JsonProperty("total_matches")
	private long totalMatches;
	
	private SummaryRes truth;
	
	private SummaryRes cube;
	
	private SummaryRes google;
	
	private SummaryRes ibm;


	public long getTotalMatches() {
		return totalMatches;
	}

	public void setTotalMatches(long totalMatches) {
		this.totalMatches = totalMatches;
	}

	public SummaryRes getTruth() {
		return truth;
	}

	public void setTruth(SummaryRes truth) {
		this.truth = truth;
	}

	public SummaryRes getCube() {
		return cube;
	}

	public void setCube(SummaryRes cube) {
		this.cube = cube;
	}

	public SummaryRes getGoogle() {
		return google;
	}

	public void setGoogle(SummaryRes google) {
		this.google = google;
	}

	public SummaryRes getIbm() {
		return ibm;
	}

	public void setIbm(SummaryRes ibm) {
		this.ibm = ibm;
	}
	
	

}
