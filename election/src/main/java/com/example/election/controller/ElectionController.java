package com.example.election.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.election.model.Election;
import com.example.election.service.ElectionService;

@RestController
public class ElectionController {
	
	@Autowired
	private ElectionService electionService;
	
	@GetMapping("/test")
	public ResponseEntity<String> testMethod(){
		return new ResponseEntity<String>("Successfull", HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Election>> getAlldata(){
		List<Election> electionList= this.electionService.getAllList();
		return new ResponseEntity<List<Election>>(electionList, HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Election>> getCustom(@RequestParam(name="voteParty", required=false)String voteParty, @RequestParam(name="orderBy", required=false)String orderBy){
		List<Election> list= this.electionService.getCustom(voteParty, orderBy);
		return new ResponseEntity<List<Election>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getByVoteParty")
	public ResponseEntity<List<Election>> getByVoteParty(@RequestParam(name="voteParty", required=false)String voteParty){
		List<Election> list= this.electionService.getByVoteParty(voteParty);
		return new ResponseEntity<List<Election>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> saveData(@RequestBody Election electionData){
		String response= this.electionService.saveData(electionData);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
