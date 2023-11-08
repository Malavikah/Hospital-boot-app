package org.jsp.hospitalBootApp.service;

import java.util.Optional;

import org.jsp.hospitalBootApp.dao.HospitalDao;
import org.jsp.hospitalBootApp.dto.Hospital;
import org.jsp.hospitalBootApp.dto.ResponseStructure;
import org.jsp.hospitalBootApp.exception.IdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {
	@Autowired
	private HospitalDao dao;
	
	public ResponseEntity<ResponseStructure<Hospital>> saveHospital(Hospital hospital){
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		hospital = dao.saveHospital(hospital);
		structure.setData(hospital);
		structure.setMessage("Hospital Registered " + hospital.getId());
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Hospital>> updateHospital(Hospital hospital){
		ResponseStructure<Hospital> structure = new ResponseStructure<>();
		hospital = dao.updateHospital(hospital);
		structure.setData(hospital);
		structure.setMessage("hospital Update Successfully " + hospital.getId());
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.ACCEPTED);
	}
	
	public ResponseEntity<ResponseStructure<String>> deleteById(int id) {
		boolean deleted = dao.deleteById(id);
		ResponseStructure<String> structure=new ResponseStructure<>();
		if(deleted) {
			structure.setData("Hospital Deleted");
			structure.setMessage("Hospital not Found");
			structure.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		structure.setData("Hospital Deleted");
		structure.setMessage("Hospital not Found");
		structure.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Hospital>> findById(int id) {
			Optional<Hospital> recHospital = dao.findById(id);
			ResponseStructure<Hospital> structure=new ResponseStructure<>();
			if (recHospital.isPresent()) 
			{
				structure.setData(recHospital.get());
				structure.setMessage("Hospital Found");
				structure.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Hospital>>(structure, HttpStatus.OK);
			}
			throw new IdNotFoundException();
		}
}

	
	
	
	
	
	
	
	
	
