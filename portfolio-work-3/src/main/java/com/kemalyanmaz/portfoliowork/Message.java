package com.kemalyanmaz.portfoliowork;

import java.sql.Date;

public class Message {
	
	@Id
	private String messageId;
	
	@Lob
	private String messageText;

	private Date messageDate;
}
