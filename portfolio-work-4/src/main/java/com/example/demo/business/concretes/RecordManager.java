package com.example.demo.business.concretes;

import org.springframework.stereotype.Service;

import com.example.demo.business.abstracts.RecordService;
import com.example.demo.core.ResponseMessage;
import com.example.demo.dataAccess.dao.RecordDao;
import com.example.demo.dataAccess.dto.RecordDto;
import com.example.demo.entities.concretes.Record;

@Service
public class RecordManager implements RecordService{

	private RecordDao recordDao;
	
	@Override
	public ResponseMessage<RecordDto> patchRecord(RecordDto recordDto,long id) {
		Record record = recordDao.findById(id).orElse(new Record());
		record.setId(id);

	}

}
