package com.nsk.service;
import com.nsk.entity.Product;
import java.util.*;
public interface ProductService {
	public Product savePord(Product p);
	public void deletePord(int pid);
	public Product getPord(int pid);
	public List<Product> getAllProd();
	public Product updateProd(Product p,int id);
}
