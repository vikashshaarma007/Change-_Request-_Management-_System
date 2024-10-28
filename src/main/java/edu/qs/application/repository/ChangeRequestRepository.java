package edu.qs.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.qs.application.model.ChangeRequest;


@Repository
public interface ChangeRequestRepository extends JpaRepository<ChangeRequest, Long> {
	

}
