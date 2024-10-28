package edu.qs.application.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import edu.qs.application.enumerations.Priority;
import edu.qs.application.model.ChangeRequest;
import edu.qs.application.model.Timeline;
import edu.qs.application.service.ChangeRequestService;
import edu.qs.application.service.TimelineService;


@Controller
public class ChangeRequestWebController {
	 @Autowired
	    private ChangeRequestService changeRequestService;

	    @Autowired
	    private TimelineService timelineService;
	    
	    
	    
	    

	    @GetMapping("/")
	    public String viewChangeRequests(Model model) {
	        List<ChangeRequest> changeRequests = changeRequestService.getAllChangeRequests();
	        model.addAttribute("changeRequests", changeRequests);
	        return "change_requests";
	    }

	    @GetMapping("/showNewchangeRequestsForm")
	    public String showNewchangeRequestsForm(Model model) {
	    	ChangeRequest changeRequest = new ChangeRequest();
	        model.addAttribute("changeRequest", changeRequest);
	        return "create_request";
	        
	    }
	    /*
	    @PostMapping("/saveChangeRequest")
	    public String saveChangeRequest(@ModelAttribute("changeRequest") ChangeRequest changeRequest) {
	    	// save employee to database
	    	changeRequestService.saveChangeRequest(changeRequest);
	    	return "redirect:/";
	    	
 }
 */
        
	    @PostMapping("/changeRequests/create")
	    public String createChangeRequest(/*@ModelAttribute("changeRequest") ChangeRequest changeRequest,*/ @RequestParam String title,
	                                      @RequestParam String description,
	                                      @RequestParam Priority priority,
	                                      @RequestParam String dueDate,
	                                      Principal principal) {
	        changeRequestService.createChangeRequest(title, description, priority, LocalDate.parse(dueDate), principal.getName());
	        return "redirect:/";
	    }

	    @GetMapping("/changeRequests/timeline/{id}")
	    public String viewTimeline(@PathVariable Long id, Model model) {
	        List<Timeline> timeline = timelineService.getTimelineForChangeRequest(id);
	        model.addAttribute("timeline", timeline);
	        return "timeline";
	    }

	    @GetMapping("/changeRequests/approve/{id}")
	    public String approveRequest(@PathVariable Long id, Principal principal) {
	        changeRequestService.approveRequest(id, principal.getName(), "Approved by Manager");
	        return "redirect:/changeRequests";
	    }

	    @GetMapping("/changeRequests/reject/{id}")
	    public String rejectRequest(@PathVariable Long id, Principal principal) {
	        changeRequestService.rejectRequest(id, principal.getName(), "Rejected by Manager");
	        return "redirect:/changeRequests";
	    } 
	    

}
