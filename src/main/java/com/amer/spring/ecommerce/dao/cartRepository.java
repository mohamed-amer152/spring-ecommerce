package com.amer.spring.ecommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.amer.spring.ecommerce.entity.cart;

public interface cartRepository extends JpaRepository<cart, Integer> {

	//id, username, productname, productquantity, productprice, producttotal, cartstatus ( initialized , confirmed)
	// customizable select and update query on cart table
	
	// 1- select
	@Query("select c from cart c where c.productname = :pn and c.username = :un and c.cartstatus ='intialized' ")
	List<cart> findSingle( @Param("pn") String prname , @Param("un") String username);
	
	// 2-update the cart quantity and product total price 
	@Transactional
	@Modifying
	@Query(" update cart c set c.productquantity = :q,c.producttotal = :pt where c.productname = :pn and c.username = :un and c.cartstatus ='intialized' ")
	void update(@Param("q") int quantity , @Param("pt") int ptotal  , @Param("pn") String pname , @Param("un") String username);
	
	
	// 3-get cart total
	@Query("select sum(producttotal) from cart c where c.username= :un and c.cartstatus='intialized' ")
	public int getcarttotal(@Param("un") String username) ;
	
	// 4- updating the cart status to confirmed
	@Transactional
	@Modifying
	@Query(" update cart c set c.cartstatus = 'confirmed' where c.username = :un ")
	public void UpdateCartStatus (@Param("un") String username);
	
	

	
	
	
}
