package com.valociraptor.events.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="messages")
public class Message {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	private String comment;
	
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
	//many to one relationship with user for message-poster
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    //many to one relationship with events
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
    private Event event;
	
	
	public Message() {
		
	}
	
	
	

    public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public Event getEvent() {
		return event;
	}




	public void setEvent(Event event) {
		this.event = event;
	}




	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	
	
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    
}
