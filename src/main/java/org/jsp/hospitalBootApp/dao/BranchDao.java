package org.jsp.hospitalBootApp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.hospitalBootApp.dto.Branch;
import org.jsp.hospitalBootApp.repository.BranchRepository;
import org.jsp.hospitalBootApp.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BranchDao {
	
	@Autowired
	private BranchRepository repository;
	
	public Branch saveBranch( Branch branch ) {
		return repository.save(branch);
	}
	
	public Branch updateBranch( Branch branch ) {
		return repository.save(branch);
	}
	
	public Optional<Branch> findById(int id) {
		return repository.findById(id);
	}	
		
//	public List<Branch> findByHospitalId(int hospital_id) {
//		return repository.findByHospitalId(hospital_id);
//	}	
//		
//	public Optional<Branch> findByGst(String gst) {
//		return repository.findByGst(gst);
//
//	}
//
//	public Optional<Branch> findByHospitalName(String name) {
//		return repository.findByHospitalName(name);
//
//	}
}