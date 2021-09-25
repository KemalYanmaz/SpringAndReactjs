package com.kemalyanmaz.portfoliowork.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kemalyanmaz.portfoliowork.models.Room;
import com.kemalyanmaz.portfoliowork.service.RoomService;

public class RoomCleanerListener {

	private static final Logger LOG = LoggerFactory.getLogger(RoomCleanerListener.class);
	
	private final ObjectMapper mapper;
	private final RoomService roomService;
	
	public RoomCleanerListener(ObjectMapper mapper, RoomService roomService) {
		super();
		this.mapper = mapper;
		this.roomService = roomService;
	}
	
	public void receiveMessage(String message) {
		try {
			AsyncPayload payload = mapper.readValue(message, AsyncPayload.class);
			if("ROOM".equals(payload.getModel())) {
				Room room = roomService.getById(payload.getId());
				LOG.info("ROOM {}:{} needs to be cleaned",room.getId(),room.getName());
			}else {
				LOG.warn("Unknown model type");
			}
			
		}catch(JsonProcessingException jpe) {
			jpe.printStackTrace();
		}
	}
	
}
