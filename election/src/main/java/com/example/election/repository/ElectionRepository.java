package com.example.election.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.election.model.Election;

public interface ElectionRepository extends MongoRepository<Election, Integer>{
	
	@Query("{'voteParty': ?0}")
	List<Election> findByVoteParty(String voteParty, Sort orderBy);

	List<Election> findByVoteParty(String voteParty);

}
