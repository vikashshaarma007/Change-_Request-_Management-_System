package edu.qs.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.qs.application.model.User;
import edu.qs.application.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    private UserRepository userRepository;

    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

	public User findUserById(Long developerId) {
		// TODO Auto-generated method stub
		return null;
	}


}
