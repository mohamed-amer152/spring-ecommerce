package com.amer.spring.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="authorities")
public class authority {

	@Id
	private String username ;
	
	private String authority ="ROLE_CUSTOMER";
}
