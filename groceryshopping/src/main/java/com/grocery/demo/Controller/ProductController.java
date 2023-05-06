package com.grocery.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.demo.Model.Product;
import com.grocery.demo.Service.ProductService;


@RestController
public class ProductController {
		@Autowired
		ProductService pservice;
		
		@GetMapping("/getAllProducts")
		public  List<Product>fetchAllProducts()
		{
			return pservice.fetchAllProducts();
		}
		
		@PostMapping("/saveProduct")
		public Product saveProduct(@RequestBody Product p)
		{
			return pservice.saveProduct(p);
			
		}
		@PutMapping("/updateProduct")
		public Product updateProduct(@RequestBody Product p)
		{
			return pservice.updateProduct(p);
		}

}
