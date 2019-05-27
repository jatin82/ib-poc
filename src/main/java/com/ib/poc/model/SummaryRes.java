package com.ib.poc.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value=Include.NON_DEFAULT)
public class SummaryRes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -18057991865198773L;

	private Long spam;
	
	@JsonProperty("not-spam")
	private long notSpam;
	
	@JsonProperty("avg-spam-score")
	private double avgSpamScore;
	
	@JsonProperty("avg-not-spam-score")
	private double avgNotSpamScore;

	public Long getSpam() {
		return spam;
	}

	public void setSpam(Long spam) {
		this.spam = spam;
	}

	public long getNotSpam() {
		return notSpam;
	}

	public void setNotSpam(long notSpam) {
		this.notSpam = notSpam;
	}

	public double getAvgSpamScore() {
		return avgSpamScore;
	}

	public void setAvgSpamScore(double avgSpamScore) {
		this.avgSpamScore = avgSpamScore;
	}

	public double getAvgNotSpamScore() {
		return avgNotSpamScore;
	}

	public void setAvgNotSpamScore(double avgNotSpamScore) {
		this.avgNotSpamScore = avgNotSpamScore;
	}
	
}
