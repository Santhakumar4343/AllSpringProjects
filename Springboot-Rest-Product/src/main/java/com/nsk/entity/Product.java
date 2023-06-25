package com.nsk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	private int pid;
	private String pname;
	private double price;
	private int quantity;
	private double total;
	private double discount;
	private double gst;
	private double servive_charges;
	private double invoice;
	public Product(int pid, String pname, double price, int quantity, double total, double discount, double gst,
			double servive_charges, double invoice) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.discount = discount;
		this.gst = gst;
		this.servive_charges = servive_charges;
		this.invoice = invoice;
	}
	public Product() {
		super();
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getServive_charges() {
		return servive_charges;
	}
	public void setServive_charges(double servive_charges) {
		this.servive_charges = servive_charges;
	}
	public double getInvoice() {
		return invoice;
	}
	public void setInvoice(double invoice) {
		this.invoice = invoice;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + ", total="
				+ total + ", discount=" + discount + ", gst=" + gst + ", servive_charges=" + servive_charges
				+ ", invoice=" + invoice + "]";
	}


}
