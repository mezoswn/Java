package com.codingdojoassignments.axsos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojoassignments.axsos.models.Comment;
import com.codingdojoassignments.axsos.models.Event;
import com.codingdojoassignments.axsos.models.User;
import com.codingdojoassignments.axsos.repositories.CommentRepository;
import com.codingdojoassignments.axsos.repositories.EventRepository;
import com.codingdojoassignments.axsos.repositories.UserRepository;




@Service
public class MainService {
	private final EventRepository eventRepository;
	public final UserRepository userRepository;
	public final CommentRepository commentRepository;

	public MainService(EventRepository eventRepository, UserRepository userRepository, CommentRepository commentRepository) {
		this.eventRepository = eventRepository;
		this.userRepository = userRepository;
		this.commentRepository = commentRepository;
	}
	
	public List<Event> allEvents() {
		return eventRepository.findAll();
	}
	
	public Event findEventById(Long id) {
		return 
		eventRepository.findById(id).isPresent() 
			? eventRepository.findById(id).get() 
			: null;
	}
	public Event createEvent(Event event) {
		Event newevent = eventRepository.save(event);
		newevent.getGuestList().add(newevent.getOwner());
		eventRepository.save(newevent);
		return newevent;
	}
	public Event editEvent(Event event) {
		Event newevent = findEventById(event.getId());
			newevent.setEvent_date(event.getEvent_date());
			newevent.setEvent_name(event.getEvent_name());
			newevent.setState(event.getState());
			newevent.setLocation(event.getLocation());
		return eventRepository.save(newevent);
	}
	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}
//	find all events in a user's state
	public List<Event> findAllEventsInUserState(String state){
		return eventRepository.findAllEventsInUserState(state);		
	}
//	find all events in a user's state
	public List<Event> findAllEventsOutOfState(String state){
		return eventRepository.findAllEventsOutOfState(state);
	}
// find all of a user's joined events	
	public List<Event> findJoinedEventsByUserId(Long id){
		return userRepository.findById(id).get().getEventsJoined();
	}
	public boolean isOwner(Long id, long eventid) {
		System.out.println("comparing event.id :" + eventid+ " vs " + " long :"+ id);
		return eventid == id;
	}
// Join event
	public void joinEvent(Long eventid, User user) {
    	Event event =  findEventById(eventid);
    	if(event == null || user == null ) {return;}
    	if(event.getGuestList().contains(user)) {return;}
		event.getGuestList().add(user);
		eventRepository.save(event);
		System.out.println("join event completed");
	}
// Leave event	
	public void leaveEvent(Long eventid, User user) {
    	Event event =  findEventById(eventid);
    	if(event == null || user == null ) {return;}
    	if(!event.getGuestList().contains(user)) {return;}
		event.getGuestList().remove(user);
		eventRepository.save(event);
		System.out.println("join event completed");		
	}
// Create Comment
	public void createComment(Long eventid, User author, Comment comment) {
		Comment newcomment = new Comment();
		Event event = findEventById(eventid);
		newcomment.setEvent(event);
		newcomment.setAuthor(author);
		newcomment.setContent(comment.getContent());
		commentRepository.save(newcomment);		
	}

}
