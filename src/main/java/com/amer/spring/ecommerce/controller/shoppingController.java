package com.amer.spring.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amer.spring.ecommerce.dao.cartRepository;
import com.amer.spring.ecommerce.dao.productRepository;
import com.amer.spring.ecommerce.entity.Orders;
import com.amer.spring.ecommerce.entity.cart;
import com.amer.spring.ecommerce.entity.product;
import com.amer.spring.ecommerce.entity.user;
import com.amer.spring.ecommerce.entity.contact;
import com.amer.spring.ecommerce.services.cartService;
import com.amer.spring.ecommerce.services.contactService;
import com.amer.spring.ecommerce.services.orderService;
import com.amer.spring.ecommerce.services.productService;

@Controller
public class shoppingController {

	@Autowired
	private productService pservice;

	@Autowired
	private cartService cservice;

	@Autowired
	private orderService oservice;

	@Autowired
	private cartRepository repo;

	@Autowired
	private productRepository prepo;
	
	@Autowired
	private contactService contactService ;

	// getting the current user
	@Autowired
	private com.amer.spring.ecommerce.services.authHelper authHelper;

	@RequestMapping(value = "/username", method = RequestMethod.GET)
	@ResponseBody
	public String currentUserNameSimple() {
		return authHelper.getName();
	}

	//
	private String CurrentUserName;
	private List<cart> carts = new ArrayList<>();
	List<product> productList = null;
	
	
	
	// routing to home page 
	@GetMapping("/home")
	public String home( Model model)
	{
		model.addAttribute("products", productList);
		return "home" ;
	}
	
	
	//routing to contact page
	@GetMapping("/contact")
	public String contact( Model model)
	{
		contact cobject = new contact();
		model.addAttribute("contact", cobject);
		return "contact" ;
	}
	

	// routing to cart page
	@GetMapping("/cart")
	public String cart(Model model) {
		CurrentUserName = currentUserNameSimple();
		List<cart> result = cservice.find();
		// filtering list based on the user current
		carts.clear();
		for (cart item : result) {
			if (item.getUsername().equals(CurrentUserName) && item.getCartstatus().equals("intialized")) {
				carts.add(item);
			}
		}
		model.addAttribute("carts", carts);
		return "cart";
		
		
		
	}

	// increasing the product Quantity and update the product total price
	@GetMapping("/increse")
	public String increase(@RequestParam("pn") String pn, Model m) {
		cart c = new cart();
		int pid = prepo.getproductid(pn);
		cservice.save(c, pid, CurrentUserName);
		return "redirect:/cart";
	}

	// decreseing the product quantity in cart
	@GetMapping("/decrese")
	public String decrese(@ModelAttribute("pn") String pn, Model m) {
		//cart c = new cart();
		int pid = prepo.getproductid(pn);
        cservice.decrese(pid, CurrentUserName);
		return "redirect:/cart";
	}

	// routing to check out page
	@GetMapping("/out")
	public String checkout(Model model) {
		int subtotal = repo.getcarttotal(CurrentUserName);
		int total = subtotal + 50;
		Orders o = new Orders();
		model.addAttribute("order", o);
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("total", total);
		model.addAttribute("cartout", carts);
		return "checkout";
	}

	
	// Retrieving the products from the database ;
	@GetMapping("/getProducts")
	public String findallproducts(Model model, @ModelAttribute user u) {
		if (productList !=null) {
			productList.clear();
		}
		CurrentUserName = currentUserNameSimple();
		productList = pservice.productList();
		cart c = new cart();
		product p = new product();
		model.addAttribute("user", u);
		model.addAttribute("product", p);
		model.addAttribute("products", productList);
		model.addAttribute("cart", c);
		
		
		if (CurrentUserName.equals("amer")) {
			return "view/adminHome" ;
		} else {
			return "home";
		}
		
	}

	// save to cart process
	@GetMapping("/save")
	public String savecart(@ModelAttribute("cart") cart c, Model model, @RequestParam("pi") String pn) {
		int product_id = Integer.parseInt(pn);
		cservice.save(c, product_id, CurrentUserName);
		return "redirect:/getProducts";
	}

	// proceed to check out

	@PostMapping("/checkout")
	public String chexk(@ModelAttribute Orders o) {

		oservice.save(o, CurrentUserName);
		return "confirmation";
	}
	
	
	// save  contact messages 
	@PostMapping("/saveContact")
	public String contactmessage( @ModelAttribute contact c , Model model)
	{
		model.addAttribute("data", true);
		contactService.save(c);
		return "contact" ;
	}
	
	
	@GetMapping("/error")
	public String caterror()
	{
		return "access-denied" ;
	}
	
	
	
	
	
	
	

}
