package com.example.demo.entities.concretes;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="responses")
public class Response {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private String id;
	
	@Column(name="script_results")
	private List<Object> scriptResult;

	@Column(name="script_error")
	private int scriptError;
	
	@Column(name="mod_id")
	private int modId;
	
	@Column(name="token")
	private String token;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Response() {
		this.id = UUID.randomUUID().toString();
	}
	public List<Object> getScriptResult() {
		return scriptResult;
	}

	public void setScriptResult(List<Object> scriptResult) {
		this.scriptResult = scriptResult;
	}

	public int getScriptError() {
		return scriptError;
	}

	public void setScriptError(int scriptError) {
		this.scriptError = scriptError;
	}

	public int getModId() {
		return modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}
	
	
	
}
