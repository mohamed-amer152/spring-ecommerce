package com.amer.spring.ecommerce;

import java.util.Date;
import java.util.Random;

public class mytest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String date = new Date().toString();
		System.out.println(date);
		
		Random t = new Random();
		int random =  t.nextInt(1000000) ;
		System.out.println(random);

	}

}
