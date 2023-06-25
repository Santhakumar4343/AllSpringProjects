package com.nsk.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.nsk.entity.Product;
import com.nsk.repo.ProductRepo;
@Service
public  class ProductImplementation implements ProductService {
	@Autowired
	private ProductRepo repo;
	@Override
	public Product savePord(Product p) {
		double total=0.0,discount=0.0,gst=0.0,invoice=0.0,servive_charges=0.0;
	   total=p.getPrice()*p.getQuantity();
	   p.setTotal(total);
	    if(total>5000) {
	    	discount=total*0.18;
	    }
	    else if(total>5000&&total<=6000) {
	    	discount=total*0.25;
	    }
	    else {
	    	discount=total*0.30;
	    }
	    p.setDiscount(discount);
	    gst=p.getTotal()*0.15;
	    p.setGst(gst);
	    servive_charges=p.getTotal()*0.12;
	  p.setServive_charges(servive_charges);
	    invoice=p.getTotal()+p.getGst()-p.getDiscount();
	    p.setInvoice(invoice);
		Product p1=repo.save(p);
		return p1;
	}
	@Override
	public void deletePord(int pid) {
		repo.deleteById(pid);
	}
	@Override
	public Product getPord(int pid) {
		Product p1=repo.findById(pid).get();
		return p1 ;
	}

	@Override
	public List<Product> getAllProd() {
		List<Product> ls=repo.findAll();
		return ls;
	}
	@Override
	public Product updateProd(Product p, int pid) {
		Product p1=repo.findById(pid).get();
		
				p1.setPname(p.getPname());
				p1.setPrice(p.getPrice());
				 return repo.save(p1);
		
	}
	

}
