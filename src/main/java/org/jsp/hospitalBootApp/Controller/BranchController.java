package org.jsp.hospitalBootApp.Controller;

import org.jsp.hospitalBootApp.dto.Branch;
import org.jsp.hospitalBootApp.dto.ResponseStructure;
import org.jsp.hospitalBootApp.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {
	@Autowired
	private BranchService service;
	
	@PostMapping("/branch/{hospital_id}")
	public ResponseEntity<ResponseStructure<Branch>> saveBranch(@RequestBody Branch branch, @PathVariable int hospital_id){
		return service.saveBranch(branch, hospital_id);
	}
	
	@PutMapping("/branch/{hospital_id}")
	public ResponseEntity<ResponseStructure<Branch>> updateBranch(@RequestBody Branch branch, @PathVariable int hospital_id){
		return service.updateBranch(branch, hospital_id);
	}
	
//	@GetMapping("/branch/{hospital_id}")
//	public ResponseEntity<ResponseStructure<Branch>> findByHospitalId(@PathVariable int hospital_id){
//		return service.findByHospitalById(hospital_id);
//	}
//	
}
