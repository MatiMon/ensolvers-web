package com.ensolvers.webexercise.domain;

import javax.persistence.Entity;

import com.ensolvers.webexercise.dtos.Persistent;

@Entity(name = "ToDoNotes")
public class ToDo extends Persistent {
	private String text;
	private Boolean status = false;

	public ToDo(String text) {
		this.text = text;
	}

	public ToDo(String text, Boolean status) {
		this.text = text;
		this.status = status;
	}

	public ToDo() {
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
