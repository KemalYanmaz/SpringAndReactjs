package com.kemalyanmaz.portfoliowork.business.concretes;

import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.SectorService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.SectorDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.SectorDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Sector;

@Service
public class SectorManager implements SectorService{

	private SectorDao sectorDao;
	
	public SectorManager(SectorDao sectorDao) {
		this.sectorDao = sectorDao;
	}
	
	@Override
	public SectorDto getById(long id) {
		return sectorToDto(sectorDao.findById(id).orElse(new Sector()));
	}
	
	private SectorDto sectorToDto(Sector sector) {
		SectorDto sectorDto = new SectorDto();
		sectorDto.setSector_name(sector.getSectorName());
		return sectorDto;
	}

	
}
