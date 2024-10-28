package edu.qs.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.qs.application.model.ChangeRequest;
import edu.qs.application.model.TeamAssignment;
import edu.qs.application.model.User;
import edu.qs.application.service.ChangeRequestService;
import edu.qs.application.service.TeamAssignmentService;
import edu.qs.application.service.UserService;

@Controller
public class TeamAssignmentController {
	@Autowired
    private TeamAssignmentService teamAssignmentService;

    @Autowired
    private ChangeRequestService changeRequestService;

    @Autowired
    private UserService userService;

    // Endpoint to assign a developer to a change request
    @PostMapping("/assign")
    public ResponseEntity<TeamAssignment> assignDeveloper(@RequestParam Long changeRequestId,
                                                          @RequestParam Long developerId) {
        ChangeRequest changeRequest = changeRequestService.getById(changeRequestId);
        User developer = userService.findUserById(developerId);
        TeamAssignment assignment = teamAssignmentService.assignDeveloperToRequest(changeRequest, developer);
        return ResponseEntity.ok(assignment);
    }

}
