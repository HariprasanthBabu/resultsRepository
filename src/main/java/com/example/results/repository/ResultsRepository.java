package com.example.results.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.results.entity.Results;

public interface ResultsRepository extends JpaRepository<Results, Integer> {
	@Query(value = "select name from prod_db.results where id=?",nativeQuery=true)
	public String getByName(int id);
	@Query(value="select total_marks from prod_db.results where id=?",nativeQuery=true)
	public int getpercentage(int id);
	@Query(value = " select distinct * from prod_db.results order by total_marks desc limit 3", nativeQuery = true)
	public List<Results> getTopThree();
	@Query(value="select roll_number from prod_db.student where id=?",nativeQuery=true)
	public int getRollNo(int id);
	@Query(value = "select * from prod_db.results where total_marks>=70 and total_marks<=90", nativeQuery = true)
	public List<Results> getMiddleStudents();

	
	

}
