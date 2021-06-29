package com.codingdojoassignments.axsos.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.User;
import com.codingdojoassignments.axsos.repositories.CommentRepository;
import com.codingdojoassignments.axsos.repositories.UserRepository;

@Service
public class UserService {
	public final UserRepository userRepository;
	public final CommentRepository commentRepository;

	public UserService(UserRepository userRepository, CommentRepository commentRepository) {
		this.userRepository = userRepository;
		this.commentRepository = commentRepository;
	}
//	register
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
        return userRepository.save(user);
	}
// find by id 
	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
			return null;
	}
//	find by email
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
// authenticate user
	public boolean authenticateUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		if (user == null) 
			{
				return false;
			}
		if(!BCrypt.checkpw(password, user.getPassword())) 
			{
				return false;
			}
		return true;
	}


}
