package com.jason.demo.handin.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class HandInResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8169390554798933288L;

	
//	@JsonProperty("timestamp")
	private Long timestamp;

//	@JsonProperty("returnCode")
	private Integer returnCode;

//	@JsonProperty("returnMessage")
	private String returnMessage;

//	@JsonProperty("email")
	private String email;

//	@JsonProperty("empoleeId")
	private Long empoleeId;

//	@JsonProperty("mode")
	private String mode;

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(Integer returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

}
