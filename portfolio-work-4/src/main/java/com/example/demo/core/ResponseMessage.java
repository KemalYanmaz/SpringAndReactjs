package com.example.demo.core;

public class ResponseMessage<T>{
	
	private T response;
	private Message message;
	
	class Message{
		 int code;
		 String message;
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}


	public T getResponse() {
		return response;
	}


	public void setResponse(T response) {
		this.response = response;
	}


	public Message getMessage() {
		return message;
	}


	public void setMessage(Message message) {
		this.message = message;
	}
	
	
}
