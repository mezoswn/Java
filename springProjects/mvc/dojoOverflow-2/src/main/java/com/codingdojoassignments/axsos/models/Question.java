package com.codingdojoassignments.axsos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.servlet.jsp.tagext.Tag;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="questions")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="Question field must not be blank")
	private String question;
	
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	private List<Answer> answer;
	
	@Column(updatable=false)
    private Date createdAt;
    
    private Date updatedAt;
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "tags_questions",
			joinColumns = @JoinColumn(name = "question_id"),
			inverseJoinColumns = @JoinColumn(name="tag_id")
			)
	private List<Tag> tags;
	
	public Question() {
		
	}
	
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
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


	public List<Answer> getAnswer() {
		return answer;
	}


	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
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


	public List<Tag> getTags() {
		return tags;
	}


	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
}
