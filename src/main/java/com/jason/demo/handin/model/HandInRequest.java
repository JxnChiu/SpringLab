package com.jason.demo.handin.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class HandInRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4078552334702690608L;

//	@JsonProperty("email")
	private String email;

//	@JsonProperty("empoleeId")
	private Long empoleeId;

//	@JsonProperty("gradeRelativeUri")
	private String gradeRelativeUri;

//	@JsonProperty("gradeHttpPort")
	private Integer gradeHttpPort;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getEmpoleeId() {
		return empoleeId;
	}

	public void setEmpoleeId(Long empoleeId) {
		this.empoleeId = empoleeId;
	}

	public String getGradeRelativeUri() {
		return gradeRelativeUri;
	}

	public void setGradeRelativeUri(String gradeRelativeUri) {
		this.gradeRelativeUri = gradeRelativeUri;
	}

	public Integer getGradeHttpPort() {
		return gradeHttpPort;
	}

	public void setGradeHttpPort(Integer gradeHttpPort) {
		this.gradeHttpPort = gradeHttpPort;
	}

}
