package com.grocery.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
	
	@Entity
	@Table(name="product")

	public class Product {
		@Id
		@GeneratedValue
		
			     
		private int sno;
		private String category;
	    private String kg;
	    private String price;
	    private String discount;
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "grocery_sno")
	 	 private Grocery groceryproduct;
	    public int getSno() {
			return sno;
		}
		public void setSno(int sno) {
			this.sno = sno;
		}
		public String getKg() {
			return kg;
		}
		public void setKg(String kg) {
			this.kg = kg;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public String getDiscount() {
			return discount;
		}
		public void setDiscount(String discount) {
			this.discount = discount;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public Grocery getGroceryproduct() {
			return groceryproduct;
		}
		public void setGroceryproduct(Grocery groceryproduct) {
			this.groceryproduct = groceryproduct;
		}
		@Override
		public String toString() {
			return "Product [sno=" + sno + ", category=" + category + ", kg=" + kg + ", price=" + price + ", discount="
					+ discount + ", groceryproduct=" + groceryproduct + "]";
		}
		
	

}
