package com.kemalyanmaz.portfoliowork.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.business.abstracts.ProductService;
import com.kemalyanmaz.portfoliowork.dataAccess.abstracts.ProductDao;
import com.kemalyanmaz.portfoliowork.dataAccess.concretes.ProductDto;
import com.kemalyanmaz.portfoliowork.entities.concretes.Product;

@Service
public class ProductManager implements ProductService{

	private ProductDao productDao;
	

	@Autowired
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public ProductDto getById(long id) {
		return productToDto(productDao.findById(id).orElse(new Product()));
	}
	
	private ProductDto productToDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setProduct_name(product.getProductName());
		productDto.setProduct_price(product.getProductPrice());
		return productDto;
	}

	
}
