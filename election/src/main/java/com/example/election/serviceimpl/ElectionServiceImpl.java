package com.example.election.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.election.model.Election;
import com.example.election.repository.ElectionRepository;
import com.example.election.service.ElectionService;

@Service
public class ElectionServiceImpl implements ElectionService {

	@Autowired
	private ElectionRepository electionRepository;

	@Override
	public List<Election> getAllList() {
		List<Election> allList = this.electionRepository.findAll();
		return allList;
	}

	@Override
	public String saveData(Election electionData) {
		try {
			this.electionRepository.save(electionData);
			return "Saved";
		} catch (Exception e) {
			return "NotSaved";
		}

	}

	@Override
	public List<Election> getCustom(String voteParty, String orderBy) {
		List<Election> list= this.electionRepository.findByVoteParty(voteParty, Sort.by(Sort.Direction.DESC, orderBy));
		return list;
	}

	@Override
	public List<Election> getByVoteParty(String voteParty) {
		List<Election> list= this.electionRepository.findByVoteParty(voteParty);
		return list;
	}

}
