package org.jsp.hospitalBootApp.repository;

import java.util.Optional;

import org.jsp.hospitalBootApp.dto.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BranchRepository extends JpaRepository<Branch, Integer>{

	@Query("select b from Branch b where b.hospital.id=?1")
	Optional<Branch> findByHospitalId(int hospital_id);
	
//	@Query("select b from Branch b where b.hospital.name=?1")
//	Optional<Branch> findByGst(String gst);
//	
//	@Query("select b from Branch b where b.hospital.gst=?1")
//	Optional<Branch> findByHospitalName(String name);

}
