package org.jsp.hospitalBootApp.repository;

import org.jsp.hospitalBootApp.dto.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

}
