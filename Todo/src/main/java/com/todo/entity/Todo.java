package com.todo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="todo")
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long todoSeqId;
	private String title;
	private String description;
	private Date timeOfEvent;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TODO_SEQ_ID", nullable = false, unique = true)
	public Long getTodoSeqId() {
		return todoSeqId;
	}

	public void setTodoSeqId(Long todoSeqId) {
		this.todoSeqId = todoSeqId;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIME_OF_EVENT")
	public Date getTimeOfEvent() {
		return timeOfEvent;
	}

	public void setTimeOfEvent(Date timeOfEvent) {
		this.timeOfEvent = timeOfEvent;
	}

	public Todo(long todoSeqId, String title, String description, Date timeOfEvent) {
		super();
		this.todoSeqId = todoSeqId;
		this.title = title;
		this.description = description;
		this.timeOfEvent = timeOfEvent;
	}

	public Todo() {
		super();
	}

	public Todo(long todoSeqId) {
		super();
		this.todoSeqId = todoSeqId;
	}

}
