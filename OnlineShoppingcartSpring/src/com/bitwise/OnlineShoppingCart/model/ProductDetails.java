package com.bitwise.OnlineShoppingCart.model;

import java.io.Serializable;

public class ProductDetails implements Serializable {
	private static final long serialVersionUID = -5263248825341397361L;
	private String name;
	private String price;
	private String size;
	private String color;
	private int stock;
	private int quantity = 0;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "ProductDetails [name=" + name + ", price=" + price + ", size=" + size + ", color=" + color + ", stock="
				+ stock + "]";
	}


}
