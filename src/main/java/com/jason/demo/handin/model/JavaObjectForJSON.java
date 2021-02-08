package com.jason.demo.handin.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class JavaObjectForJSON implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4078552334702690608L;

	@JsonProperty("id")
	private String id;

	@JsonProperty("name")
	private Long name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getName() {
		return name;
	}

	public void setName(Long name) {
		this.name = name;
	}

}
