package edu.qs.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.qs.application.model.Timeline;
import edu.qs.application.repository.TimelineRepository;

@Service
public class TimelineService {
	@Autowired
    private TimelineRepository timelineRepository;

    public List<Timeline> getTimelineForChangeRequest(Long changeRequestId) {
        return timelineRepository.findByChangeRequestId(changeRequestId);
    }

}
