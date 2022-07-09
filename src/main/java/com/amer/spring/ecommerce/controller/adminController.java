package com.amer.spring.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.amer.spring.ecommerce.dao.productRepository;
import com.amer.spring.ecommerce.entity.Orders;
import com.amer.spring.ecommerce.entity.contact;
import com.amer.spring.ecommerce.entity.product;
import com.amer.spring.ecommerce.services.contactService;
import com.amer.spring.ecommerce.services.orderService;
import com.amer.spring.ecommerce.services.productService;

@Controller
public class adminController {
	
	@Autowired
	private productService pservice ;
	
	@Autowired
	private productRepository repo ;
	
	@Autowired
	private contactService cservice ;
	
	@Autowired 
	private orderService oservice ;
	
	      // admin home
	      @GetMapping("/ahome")
	      public String adminhome ( Model model)
	      {
	    	  List<product> products = pservice.productList();
				model.addAttribute("products", products);
	    	  return "view/adminHome" ;
	      }
	
	     // forward to product save page 
	     @GetMapping("/tosave")
	     public String tosave(Model model)
	     {
	    	 product p = new product();
	    	 model.addAttribute("product", p);
	    	 return "view/product" ;
	     }
	
	  // forward to product update page 
	     @GetMapping("/toupdate")
	     public String toupdate( @RequestParam("pid") int pid, Model model)
	     {
	    	 
	    	 Optional<product> presult = repo.findById(pid);
	    	 product p = presult.get();
	    	 model.addAttribute("product", p);
	    	 return "view/product" ;
	     }
	     
	
	    // saving the products into database
		@PostMapping("/saveProduct")
		public String save(@ModelAttribute product p, Model model) {
			pservice.save(p);
			List<product> products = pservice.productList();
			model.addAttribute("products", products);
			return "redirect:/ahome";
		}
		
		
		//deleteing product 
		@GetMapping("/delete")
		public String delete(@ModelAttribute("pid") int id , Model model)
		{
			pservice.delete(id);
			List<product> products = pservice.productList();
			model.addAttribute("products", products);
			return "redirect:/ahome" ;
		}
		
		
		
		
		// routing to the messages 
		@GetMapping("/message")
		public String messages (Model model)
		{
			List<contact> messages = cservice.find();
			model.addAttribute("messages", messages);
			return "view/message" ;
		}
		
		
		// routing to orders page 
		@GetMapping("/order")
		public String getorders( Model model)
		{
			List<Orders> orders = oservice.getorders();
			model.addAttribute("orders", orders);
			return "view/orders";
		}
		
		
		
		
		
		
		
		
		


}
