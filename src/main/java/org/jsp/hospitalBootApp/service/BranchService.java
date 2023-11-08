package org.jsp.hospitalBootApp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.hospitalBootApp.dao.BranchDao;
import org.jsp.hospitalBootApp.dao.HospitalDao;
import org.jsp.hospitalBootApp.dto.Branch;
import org.jsp.hospitalBootApp.dto.Hospital;
import org.jsp.hospitalBootApp.dto.ResponseStructure;
import org.jsp.hospitalBootApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
	@Autowired
	private BranchDao dao;
	@Autowired
	private HospitalDao hospitalDao;
	
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(Branch branch, int hospital_id) {
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		Optional<Hospital> recHospital = hospitalDao.findById(hospital_id);
		if( recHospital.isPresent())
		{
			Hospital h= recHospital.get();
			h.getBranchs().add(branch);
			hospitalDao.updateHospital(h);
			dao.saveBranch(branch);
			structure.setData(branch);
			structure.setMessage("Branch Added");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
		}	
		throw new IdNotFoundException();
	}
	
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int hospital_id) {
		ResponseStructure<Branch> structure=new ResponseStructure<>();
		Optional<Hospital> recHospital = hospitalDao.findById(hospital_id);
		if( recHospital.isPresent())
		{
			Hospital h= recHospital.get();
			h.getBranchs().add(branch);
			hospitalDao.updateHospital(h);
			dao.saveBranch(branch);
			structure.setData(branch);
			structure.setMessage("Branch Updated");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Branch>>(structure, HttpStatus.CREATED);
		}	
		throw new IdNotFoundException();
	}
	
//	public ResponseEntity<ResponseStructure<List<Branch>>> findByHospitalId(int hospital_id) {
//		ResponseStructure<List<Branch>> structure=new ResponseStructure<>();
//		Optional<Hospital> recHospital = hospitalDao.findById(hospital_id);
//		if( recHospital.isPresent())
//		{
//			structure.setData(dao.findByHospitalId(hospital_id));
//			structure.setMessage("Branch Found");
//			structure.setStatusCode(HttpStatus.OK.value());
//			return new ResponseEntity<ResponseStructure<List<Branch>>>(structure, HttpStatus.OK);
//		}	
//		throw new IdNotFoundException();
//	}	
	
	
}
