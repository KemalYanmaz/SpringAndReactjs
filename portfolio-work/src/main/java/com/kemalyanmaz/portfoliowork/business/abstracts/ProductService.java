package com.kemalyanmaz.portfoliowork.business.abstracts;

import com.kemalyanmaz.portfoliowork.dataAccess.concretes.ProductDto;

public interface ProductService {
	ProductDto getById(long id);
}
