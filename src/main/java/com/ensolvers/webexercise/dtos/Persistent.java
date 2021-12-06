package com.ensolvers.webexercise.dtos;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Persistent {

	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

}
