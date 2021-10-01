package com.example.demo.dataAccess.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ResponseDto {
	
	private List<String> scriptResult;
	private int scriptError;
	private int modId;
	
	public List<String> getScriptResult() {
		return scriptResult;
	}
	public void setScriptResult(List<String> scriptResult) {
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
