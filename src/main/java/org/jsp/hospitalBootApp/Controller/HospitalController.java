package org.jsp.hospitalBootApp.Controller;

import org.jsp.hospitalBootApp.dto.Hospital;
import org.jsp.hospitalBootApp.dto.ResponseStructure;
import org.jsp.hospitalBootApp.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HospitalController {
	
	@Autowired
	private HospitalService service;
	
	@PostMapping("/hospitals")
	ResponseEntity<ResponseStructure<Hospital>> saveHospital(@RequestBody Hospital hospital){
		return service.saveHospital(hospital);
	}
	
	@PutMapping("/hospitals/{id}")
	ResponseEntity<ResponseStructure<Hospital>> updateHospital(@RequestBody Hospital hospital, @PathVariable int id){
		return service.updateHospital(hospital);
	}
	
	@GetMapping("/hospitals/{id}")
	ResponseEntity<ResponseStructure<Hospital>> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@DeleteMapping("/hospitals/{id}")
	ResponseEntity<ResponseStructure<String>> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}
	
}
