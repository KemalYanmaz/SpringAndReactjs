package com.kemalyanmaz.portfoliowork.business.abstracts;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.SectorDto;

public interface SectorService {

	SectorDto getById(long id);
}
