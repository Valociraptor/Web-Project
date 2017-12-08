package com.valociraptor.overflow.models;

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
import javax.validation.constraints.Size;

@Entity
@Table(name="questions")
public class Question {
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, message="ARE YOU KIDDING ME, put in a question.  The hell is wrong with you?")
	private String question;
	
    @Column(updatable=false)
    private Date createdAt;
    
    private Date updatedAt;
    
    
    @OneToMany(mappedBy="question", fetch = FetchType.LAZY)
    private List<Answer> answers;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "questions_tags",
    		joinColumns = @JoinColumn(name="question_id"),
    		inverseJoinColumns = @JoinColumn(name="tag_id")
    )
    
    @Size(max=3, message="Sorry, no more than 3 tags there slick")
    private List<Tag> tags;
    
    public Question() {
    	
    }
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
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

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
    
    
}
