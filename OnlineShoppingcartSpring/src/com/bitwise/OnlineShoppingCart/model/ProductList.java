package com.bitwise.OnlineShoppingCart.model;

import java.util.List;

public class ProductList {

	private List<ProductDetails> productDetails;

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		//System.out.println("Before setting");
		for (ProductDetails tmpProductDetails : productDetails) {
			System.out.println(tmpProductDetails);
		}
		this.productDetails = productDetails;
	}

	@Override
	public String toString() {
		return "ProductList [productDetails=" + productDetails + "]";
	}

	public ProductDetails getProductByProductName(String pname) {
		for (ProductDetails pro : productDetails) {
			if (pro.getName().equals(pname)) {
				return pro;
			}
		}
		return null;
	}

}
