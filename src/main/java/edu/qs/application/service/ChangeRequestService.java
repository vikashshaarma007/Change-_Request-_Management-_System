package edu.qs.application.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.qs.application.enumerations.Priority;
import edu.qs.application.enumerations.RequestStatus;
import edu.qs.application.model.ChangeRequest;
import edu.qs.application.model.Timeline;
import edu.qs.application.model.User;
import edu.qs.application.repository.ChangeRequestRepository;
import edu.qs.application.repository.TimelineRepository;
import edu.qs.application.repository.UserRepository;



@Service
public class ChangeRequestService {
	@Autowired
    private ChangeRequestRepository changeRequestRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TimelineRepository timelineRepository;

    public List<ChangeRequest> getChangeRequests() {
		return changeRequestRepository.findAll();
		
		
    }
    
    public void SaveChangeRequest(ChangeRequest changeRequest) {
		this.changeRequestRepository.save(changeRequest);
	}
    
		
    public ChangeRequest createChangeRequest(String title, String description, Priority priority, 
                                             LocalDate dueDate, String requesterUsername) {
        User requester = userRepository.findByUsername(requesterUsername);

        ChangeRequest changeRequest = new ChangeRequest();
        changeRequest.setTitle(title);
        changeRequest.setDescription(description);
        changeRequest.setPriority(priority);
        changeRequest.setDueDate(dueDate);
        changeRequest.setStatus(RequestStatus.PENDING);
        changeRequest.setRequester(requester);

        Timeline timeline = new Timeline();
        timeline.setChangeRequest(changeRequest);
        timeline.setStatus("Request Raised");
        timeline.setStartDate(LocalDate.now());

        changeRequestRepository.save(changeRequest);
        timelineRepository.save(timeline);
        return changeRequest;
    }

    public ChangeRequest approveRequest(Long id, String managerUsername, String comment) {
        ChangeRequest request = changeRequestRepository.findById(id).orElseThrow();
        request.setStatus(RequestStatus.APPROVED);

        Timeline timeline = new Timeline();
        timeline.setChangeRequest(request);
        timeline.setStatus("Approved");
        timeline.setStartDate(LocalDate.now());
        timeline.setComments(comment);

        changeRequestRepository.save(request);
        timelineRepository.save(timeline);
        return request;
    }

	public ChangeRequest getById(Long changeRequestId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	public void rejectRequest(Long id, String name, String string) {
		// TODO Auto-generated method stub
		
	}

	public List<ChangeRequest> getAllChangeRequests() {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveChangeRequest(ChangeRequest changeRequest) {
		// TODO Auto-generated method stub
		
	}

}
