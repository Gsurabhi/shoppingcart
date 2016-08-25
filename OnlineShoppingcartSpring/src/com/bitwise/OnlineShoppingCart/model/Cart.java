package com.bitwise.OnlineShoppingCart.model;

import java.util.ArrayList;
import java.util.List;

import com.bitwise.OnlineShoppingCart.exceptions.OutOfStockException;

public class Cart {
	int cartSize;
	double cartValue;
    //Cart cart = new Cart();
	List<ProductDetails> cartItems = new ArrayList<ProductDetails>();

	public int getCartSize() {
		return this.cartItems.size();
	}

	public void setCartSize(int cartSize) {
		this.cartSize = cartSize;
	}

	public double getCartValue() {
		return cartValue;
	}

	public void setCartValue(double cartValue) {
		this.cartValue = cartValue;
	}

	public List<ProductDetails> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<ProductDetails> cartItems) {
		this.cartItems = cartItems;
	}
	
	

	public int addItem(ProductDetails pd) {
		if (inStock(pd)) {
			
			if(cartItems.contains(pd))
			{
			
				cartValue += Integer.parseInt(pd.getPrice());
				pd.setQuantity(pd.getQuantity() + 1);
				pd.setStock(pd.getStock() - 1);
				
			}
			else
			{
			cartValue += Integer.parseInt(pd.getPrice());
			pd.setQuantity(pd.getQuantity() + 1);
			pd.setStock(pd.getStock() - 1);
			
			cartItems.add(pd);
			System.out.println(cartSize + " " + cartValue + " ");
			}
		} else
			throw new OutOfStockException("Product out of stock");
		return getCartSize();
	}

	private boolean inStock(ProductDetails pd) {
		if (pd.getStock() - 1 < 0)
			return false;
		return true;
	}

	public ProductDetails getProductByProductName(String pname) {
		for (ProductDetails pro : cartItems) {
			if (pro.getName().equals(pname)) {
				return pro;
			}
		}
		return null;
	}

	public void removeItem(ProductDetails product) {
			if(cartItems.contains(product))
			{
				if(product.getQuantity() == 1)
				{
				cartValue -= Integer.parseInt(product.getPrice());
				product.setStock(product.getStock() + 1);
				cartItems.remove(product);
				}
				else
				{
					cartValue -= Integer.parseInt(product.getPrice());
					product.setQuantity(product.getQuantity() - 1);
					product.setStock(product.getStock() + 1);
				}
					
			}
		
		

		
		
		
	}

}
