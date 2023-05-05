package com.example.results.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.results.controller.service.ResultsService;
import com.example.results.entity.Results;
import com.example.results.entity.StudentDetails;
import com.example.results.entity.StudentMark;

@RestController
public class ResultsController {
	@Autowired
	ResultsService resSer;
	@Autowired
	RestTemplate rest;

	@PostMapping(value = "/addResults")
	public String addResults() {
		String url1="http://localhost:8080/getAll";
		String url2="http://localhost:8081/getAllMark";
		List<Results> res=new ArrayList<>();
		ResponseEntity<List<StudentDetails>> res1 = rest.exchange(url1, HttpMethod.GET, null, new ParameterizedTypeReference<List<StudentDetails>>() {});
	List<StudentDetails> stud=res1.getBody();
	
	ResponseEntity<List<StudentMark>> res2 = rest.exchange(url2, HttpMethod.GET, null, new ParameterizedTypeReference<List<StudentMark>>() {});
	List<StudentMark> stud1=res2.getBody();
	
	int id=0;
	int rollNo=0;
	String name= null;
	int totalMarks=0;
	int percentage=0;
	
	for(int i=0; i<stud.size(); i++) {
		id=stud.get(i).getId();
		rollNo=stud.get(i).getRollNumber();
		name=stud.get(i).getName();
		if(stud.get(i).getAttendence()>90) {
			totalMarks=((stud1.get(i).getSem1Total()+stud1.get(i).getSem2Total())/4)+5;
		}
		else {
			totalMarks=(stud1.get(i).getSem1Total()+stud1.get(i).getSem2Total()/4);
		}
		if(((stud1.get(i).getSem1Total()+stud1.get(i).getSem2Total())/4)+5 >100) {
			totalMarks=100;
		}
		
		percentage=totalMarks;
		res.add(new Results(id,rollNo,name,totalMarks,percentage));
	}
	return resSer.addResults(res);

	}
	@GetMapping(value = "/getIdforList/{id}")
	public Results getResults(@PathVariable int id) {
		return resSer.getResults(id);
	}

	@DeleteMapping(value = "/delete/{id}")
	public String deleteResults(@PathVariable int id) {
		return resSer.deleteResults(id);
	}

	@PostMapping(value = "/listAdd")
	public String addResultss(@RequestBody List<Results> sts) {
		return resSer.addResultss(sts);

	}

	@GetMapping(value = "/getList")
	public List<Results> getResultss() {
		return resSer.getResultss();
	}

	@PutMapping(value = "/update/{id}")
	public String updateResults(@RequestBody Results id) {
		return resSer.updateResults(id);
	}
	@GetMapping(value="/getByName/{id}") 
	public String getByName(@PathVariable int id) {
		return resSer.getByName(id);
	}
	@GetMapping(value="/getpercentage/{id}")
	public int getpercentage(@PathVariable int id) {
		return resSer.getpercentage(id)/4;
	}
	@GetMapping(value="getRollNo/{id}")
	public int getRollNo(@PathVariable int id) {
		return resSer.getRollNo(id);
	}
	@GetMapping(value="getTopThree") 
	public List<Results> getTopThree() {
		return resSer.getTopThree();
	}
	@GetMapping(value="getMiddleStudents") 
	public List<Results> getMiddleStudents() {
		return resSer.getMiddleStudents();
	}
	
}
