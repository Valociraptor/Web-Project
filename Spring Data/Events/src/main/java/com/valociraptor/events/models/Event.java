package com.valociraptor.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="events")
public class Event {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank
	private String name;
	@Future
	private Date date;
	@NotBlank
	private String location;
	@NotBlank
	private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    
	// Many to One relationship for  creator of event
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
	//many to many relationship for events attended by users
    @ManyToMany(fetch =FetchType.LAZY)
    @JoinTable(
    		name = "users_events",
    		joinColumns = @JoinColumn(name="event_id"),
    		inverseJoinColumns = @JoinColumn(name="attendee_id")
    		)
    private List<User> attendees;
    
	//one to many relationship for messages
    @OneToMany(mappedBy="event", fetch = FetchType.LAZY)
    private List<Message> messages;
    
    
    public Event() {
    	
    }
    

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<User> getAttendees() {
		return attendees;
	}



	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}



	public List<Message> getMessages() {
		return messages;
	}



	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    

    

}
