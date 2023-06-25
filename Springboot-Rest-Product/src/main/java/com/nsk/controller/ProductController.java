package com.nsk.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nsk.entity.Product;
import com.nsk.service.ProductImplementation;
@RestController
public class ProductController {
@Autowired
private ProductImplementation services;
@PostMapping("/save")
public String saveProdt(@RequestBody Product p) {
	 Product p1=services.savePord(p);
	String s=null;
	if(p!=null) {
		s="inserted successfully";
	}
	else {
		s="something went worng";
	}
	return s;
}
@DeleteMapping("/delete/{pid}")
public void deleteProduct( @PathVariable int pid) {
	services.deletePord(pid);
}
@GetMapping("/get/{pid}")
public Product getProduct(@PathVariable int pid) {
	 
			return  services.getPord(pid);
}
@GetMapping("/getAll")
public List<Product> getAllProduct(){
	  return services.getAllProd();
}
@PutMapping("/update/{pid}")
public Product updateProduct(@RequestBody Product p,@PathVariable int pid) {
	return services.updateProd(p, pid);	
}
}
