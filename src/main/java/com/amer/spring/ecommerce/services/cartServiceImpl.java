package com.amer.spring.ecommerce.services;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amer.spring.ecommerce.dao.cartRepository;
import com.amer.spring.ecommerce.dao.productRepository;
import com.amer.spring.ecommerce.entity.cart;
import com.amer.spring.ecommerce.entity.product;
@Service
public class cartServiceImpl implements cartService {
	
    Logger LOGGER = Logger.getLogger(cartService.class.getName());

	@Autowired
	private cartRepository repo ;
	
	@Autowired
	private productRepository prepo ; 

	@Override
	public void save(cart c, int pid, String uname) {
		// TODO Auto-generated method stub
		// first of all i will check if the product is already exist in the cart table 
		// if not i will save new cart object or will update the existed object
		Optional<product> p = prepo.findById(pid);
		product oneproduct = p.get();
		List<cart> result = repo.findSingle(oneproduct.getProduct_name(), uname);
		if (result.isEmpty()) {
			// set the product quantity to 1
			// cart table fields name     id, username, productname, productquantity, productprice, producttotal, cartstatus
			c.setProductquantity(1);
			c.setProductname(oneproduct.getProduct_name());
			c.setUsername(uname);
			c.setProductprice(oneproduct.getProduct_price());
			c.setProducttotal(oneproduct.getProduct_price());
			c.setProductimg(oneproduct.getProduct_image());
//			LOGGER.info(pname + "**************************************************");
//			LOGGER.info(uname + "**************************************************");
			repo.save(c);
		} else {
			// in this case the customer has already that product in his cart 
			// so i will update the quantity and the price 
			
			int quantity = result.get(0).getProductquantity() +1 ;
			int producttotal = result.get(0).getProducttotal() + oneproduct.getProduct_price();
			repo.update(quantity, producttotal, oneproduct.getProduct_name(), uname);

		}
		
		
	}

	@Override
	public List<cart> find() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	
	// updating the cart table product quantity and product total 
	public void decrese(int pid , String username)
	{
		Optional<product> p = prepo.findById(pid);
		product oneproduct = p.get();
		List<cart> result = repo.findSingle(oneproduct.getProduct_name(), username);
		// if condition to check if the quantity is equal to one this will 
		// remove that product from that cart object 
		

		int quantity = result.get(0).getProductquantity() - 1 ;
		int producttotal = result.get(0).getProducttotal() - oneproduct.getProduct_price();
		//repo.update(quantity, producttotal, oneproduct.getProduct_name(), uname);
		if (quantity == 0) {
			repo.delete(result.get(0));
		} else {
			repo.update(quantity, producttotal, oneproduct.getProduct_name(), username);
		}
		
		
	}
	
	
	
	
}
