package edu.qs.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.qs.application.model.TeamAssignment;

@Repository
public interface TeamAssignmentRepository extends JpaRepository<TeamAssignment, Long> {
	

}
