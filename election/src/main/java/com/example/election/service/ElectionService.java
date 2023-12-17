package com.example.election.service;

import java.util.List;

import com.example.election.model.Election;

public interface ElectionService {

	List<Election> getAllList();

	String saveData(Election electionData);

	List<Election> getCustom(String voteParty, String orderBy);

	List<Election> getByVoteParty(String voteParty);

}
