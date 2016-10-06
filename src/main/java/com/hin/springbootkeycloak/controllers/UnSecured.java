/**
 * 
 */
package com.hin.springbootkeycloak.controllers;

import java.util.List;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.adapters.RefreshableKeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hin.springbootkeycloak.dto.Product;
import com.hin.springbootkeycloak.repo.ProductRepository;

/**
 * @author nourreddine
 *
 */
@RestController
@RequestMapping(path= "unsecured")
@CrossOrigin(origins={"*"})
public class UnSecured {

	@Autowired
	private ProductRepository repo;
	
	@RequestMapping(
			method=RequestMethod.GET,
			path="/products",   
			produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Product> getProductsSecured(KeycloakPrincipal<RefreshableKeycloakSecurityContext> principal){
		
		System.out.println(principal);
		return repo.findAll();
	}	
	
}
