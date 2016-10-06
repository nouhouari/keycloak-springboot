/**
 * 
 */
package com.hin.springbootkeycloak.repo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.hin.springbootkeycloak.dto.Product;

/**
 * @author nourreddine
 *
 */
@Component
public class ProductRepository {

	List<Product> products = new ArrayList<Product>();
	
	@PostConstruct
	private void init(){
		for (int i = 0; i < 10; i++) {
			Product p = new Product();
			p.setId(i);
			p.setName("Product"+i);
			products.add(p);
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Product> findAll(){
		return products;
	}
	
}
