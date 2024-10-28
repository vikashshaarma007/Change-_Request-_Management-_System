package edu.qs.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.qs.application.model.Timeline;
import edu.qs.application.service.TimelineService;
@Controller
public class TimelineControlle {
	@Autowired
    private TimelineService timelineService;

    // Endpoint to retrieve the timeline for a specific change request
    @GetMapping("/changeRequest/{id}")
    public ResponseEntity<List<Timeline>> getTimeline(@PathVariable Long id) {
        List<Timeline> timeline = timelineService.getTimelineForChangeRequest(id);
        return ResponseEntity.ok(timeline);
    }
}
