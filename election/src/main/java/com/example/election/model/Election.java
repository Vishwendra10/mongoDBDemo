package com.example.election.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "election")
public class Election {

	private int id;
	private String voteParty;

	public Election() {

	}

	public Election(int id, String voteParty, String city) {
		super();
		this.id = id;
		this.voteParty = voteParty;
		this.city = city;
	}

	private String city;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVoteParty() {
		return voteParty;
	}

	public void setVoteParty(String voteParty) {
		this.voteParty = voteParty;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
