package edu.qs.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.qs.application.model.Timeline;

@Repository
public interface TimelineRepository extends JpaRepository<Timeline, Long> {

	List<Timeline> findByChangeRequestId(Long changeRequestId);

}
