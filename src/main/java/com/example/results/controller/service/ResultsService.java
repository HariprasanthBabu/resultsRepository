package com.example.results.controller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.results.dao.ResultsDao;
import com.example.results.entity.Results;

@Service
public class ResultsService {
	@Autowired
	ResultsDao resDao;

	public String addResults(List<Results> sts) {

		return resDao.addResults(sts);
	}

	public Results getResults(int id) {
		return resDao.getResults(id);
	}

	public String deleteResults(int id) {
		return resDao.deleteResults(id);
	}

	public String addResultss(List<Results> sts) {
		return resDao.addResultss(sts);

	}

	public List<Results> getResultss() {
		return resDao.getResultss();
	}

	public String updateResults(Results id) {
		return resDao.updateResults(id);
	}

	public String getByName(int id) {
		return resDao.getByName(id);
	}

	public int getpercentage(int id) {
		return resDao.getpercentage(id);
	}

	public int getRollNo(int id) {
		return resDao.getRollNo(id);
	}
	public List<Results> getTopThree() {
		return resDao.getTopThree();
	}
	public List<Results> getMiddleStudents() {
		return resDao.getMiddleStudents();
	}

}
