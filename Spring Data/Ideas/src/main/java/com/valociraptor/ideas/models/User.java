package com.valociraptor.ideas.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Size(min=2, message="Alias must be at least 2 characters")
    private String username;
    @Size(min=2, message="Name must be at least 2 characters")
    private String name;
    @Email
    private String email;
    private Long likeCount;
    @Size(min=8, message="Password must be at least 8 characters")
    private String password;
    @Transient
    private String passwordConfirmation;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "users_roles", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;
    
    // One to Many for idea-creator
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
    private List<Idea> ideas;
    
   // Many to Many for likes
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "likes",
   		joinColumns = @JoinColumn(name="user_id"),
    		inverseJoinColumns = @JoinColumn(name = "idea_id")
    		)
    private List<Idea> likedIdeas;
    
    
    
	public User() {
		
	}
    
	
	

	public Long getLikeCount() {
		return likeCount;
	}




	public void setLikeCount(Long likeCount2) {
		this.likeCount = likeCount2;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}




	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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




	public List<Role> getRoles() {
		return roles;
	}




	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}




	public List<Idea> getIdeas() {
		return ideas;
	}




	public void setIdeas(List<Idea> ideas) {
		this.ideas = ideas;
	}




	public List<Idea> getLikedIdeas() {
		return likedIdeas;
	}




	public void setLikedIdeas(List<Idea> likedIdeas) {
		this.likedIdeas = likedIdeas;
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

