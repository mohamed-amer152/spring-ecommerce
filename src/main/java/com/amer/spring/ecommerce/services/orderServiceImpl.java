package com.amer.spring.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amer.spring.ecommerce.dao.cartRepository;
import com.amer.spring.ecommerce.dao.orderRepository;
import com.amer.spring.ecommerce.entity.Orders;
@Service
public class orderServiceImpl implements orderService {

	@Autowired
	private orderRepository repo ;
	@Autowired
	private cartRepository crepo ;
	
	@Override
	public void save(Orders o , String username) {
		// TODO Auto-generated method stub
		// id, username, orderdate, customeraddress, customerphone, ordertotal,
		// orderstatus, ordernumber
        o.setUsername(username);
        int ordertotal = crepo.getcarttotal(username);
        o.setOrdertotal(ordertotal);
        repo.save(o);
        // update the cart status to confirmed for that specific user 
		crepo.UpdateCartStatus(username);
		
	}

	@Override
	public List<Orders> getorders() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
