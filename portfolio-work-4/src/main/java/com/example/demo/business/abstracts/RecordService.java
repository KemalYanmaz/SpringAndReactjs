package com.example.demo.business.abstracts;

import com.example.demo.core.ResponseMessage;
import com.example.demo.dataAccess.dto.RecordDto;

public interface RecordService {
	
	public ResponseMessage<RecordDto> patchRecord(RecordDto recordDto,long id);
}
