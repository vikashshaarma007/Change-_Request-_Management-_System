package edu.qs.application.controller;


import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.qs.application.enumerations.Priority;
import edu.qs.application.model.ChangeRequest;
import edu.qs.application.service.ChangeRequestService;
import edu.qs.application.service.UserService;

@Controller
public class ChangeRequestController {
	 @Autowired
	    private ChangeRequestService changeRequestService;

	    @Autowired
	    private UserService userService;

	    // Endpoint to create a new change request
	    @PostMapping("/create")
	    public ResponseEntity<ChangeRequest> createChangeRequest(@RequestParam String title,
	                                                             @RequestParam String description,
	                                                             @RequestParam Priority priority,
	                                                             @RequestParam LocalDate dueDate,
	                                                             Principal principal) {
	        ChangeRequest createdRequest = changeRequestService.createChangeRequest(title, description, priority, dueDate, principal.getName());
	        return ResponseEntity.ok(createdRequest);
	    }

	    // Endpoint for manager to approve a change request
	    @PostMapping("/approve/{id}")
	    public ResponseEntity<String> approveRequest(@PathVariable Long id,
	                                                 @RequestParam String comment,
	                                                 Principal principal) {
	        changeRequestService.approveRequest(id, principal.getName(), comment);
	        return ResponseEntity.ok("Change request approved");
	    }
}
