package org.jsp.hospitalBootApp.dao;

import java.util.Optional;

import org.jsp.hospitalBootApp.dto.Hospital;
import org.jsp.hospitalBootApp.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HospitalDao {
	
	@Autowired
	private HospitalRepository repository;
	
	public Hospital saveHospital(Hospital hospital){
		System.out.println(repository);
		return repository.save(hospital);
	}
	
	
	public Hospital updateHospital(Hospital hospital) {
		return repository.save(hospital);
	}
	
	public Optional<Hospital> findById(int id){
		return repository.findById(id);
	}
	
	public boolean deleteById(int id) {
		Optional<Hospital> recHospital = findById(id);
		if (recHospital.isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
