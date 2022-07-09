package com.amer.spring.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amer.spring.ecommerce.dao.productRepository;
import com.amer.spring.ecommerce.entity.product;
@Service
public class productServiceImpl implements productService {

	@Autowired
	private productRepository repo ;
	
	@Override
	public void save(product p) {
		p.setProduct_image("img/product/"+p.getProduct_image());
        repo.save(p);
	}

	

	@Override
	public List<product> productList() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}



	@Override
	public void delete(int id) {

       repo.deleteById(id);		
	}

}
