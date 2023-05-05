package com.example.results.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.example.results.entity.Results;
import com.example.results.repository.ResultsRepository;

@Repository
public class ResultsDao {
	@Autowired
	ResultsRepository resRepo;
	public String addResults(List<Results> sts) {
		resRepo.saveAll(sts);
		return "Successfully Saved";
	}
	public Results getResults(int id) {
		return resRepo.findById(id).get();
	}

	public String deleteResults(int id) {
		resRepo.deleteById(id);
		return "Deleted";
	}

	public String addResultss(List<Results> sts) {
		resRepo.saveAll(sts);
		return "added";

	}

	public List<Results> getResultss() {
		return resRepo.findAll();
	}

	public String updateResults(Results id) {
		resRepo.save(id);
		return "Updated";
	}
	public String getByName(int id) {
		return resRepo.getByName(id);
	}
	public int getpercentage(int id) {
		return resRepo.getpercentage(id);
	}
	public String addResults() {
		return "Saved";
	}
	public int getRollNo(int id) {
		return resRepo.getRollNo(id);
	}
	public List<Results> getTopThree() {
		return resRepo.getTopThree();
	}
	public List<Results> getMiddleStudents() {
		return resRepo.getMiddleStudents();
	}
	

}
