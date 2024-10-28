package edu.qs.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.qs.application.model.ChangeRequest;
import edu.qs.application.model.TeamAssignment;
import edu.qs.application.model.User;
import edu.qs.application.repository.TeamAssignmentRepository;

@Service
public class TeamAssignmentService {
	@Autowired
    private TeamAssignmentRepository teamAssignmentRepository;

    public TeamAssignment assignDeveloperToRequest(ChangeRequest changeRequest, User developer) {
        TeamAssignment teamAssignment = new TeamAssignment();
        teamAssignment.setChangeRequest(changeRequest);
        teamAssignment.setDeveloper(developer);
        return teamAssignmentRepository.save(teamAssignment);
    }


}
