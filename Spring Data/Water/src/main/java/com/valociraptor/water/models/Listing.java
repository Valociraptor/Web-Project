package com.valociraptor.water.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="listings")
public class Listing {
	
    @Id
    @GeneratedValue
    private Long id;
    
    @NotBlank
    private String address;    
    @NotBlank
    private String location;    
    @NotBlank
    private String state;    
    @NotBlank
    private String zipcode;
    
    @NotBlank
    private String poolSize;    
    @NotBlank
    private Double cost;    
    @NotBlank
    private String desc;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    // Many to one for listing owner
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    // One to many for reviews
    @OneToMany(mappedBy="listing", fetch = FetchType.LAZY)
    private List<Review> reviews;
    
   
    
    public Listing () {
    	
    }
       
    
    
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
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





	public String getZipcode() {
		return zipcode;
	}





	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}





	public String getPoolSize() {
		return poolSize;
	}





	public void setPoolSize(String poolSize) {
		this.poolSize = poolSize;
	}





	public Double getCost() {
		return cost;
	}





	public void setCost(Double cost) {
		this.cost = cost;
	}





	public String getDesc() {
		return desc;
	}





	public void setDesc(String desc) {
		this.desc = desc;
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





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}





	public List<Review> getReviews() {
		return reviews;
	}





	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
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
