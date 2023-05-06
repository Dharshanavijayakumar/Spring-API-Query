package com.grocery.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.demo.Model.Product;
import com.grocery.demo.Repository.ProductRepository;

	
	@Service
	public class ProductService {
			@Autowired
			ProductRepository productRepository;
			
			public List<Product> fetchAllProducts()
			{
				return productRepository.findAll();
			}
			
			public Product saveProduct(Product p)
			{
				return productRepository.save(p);
				
			}

			public Product updateProduct(Product p) {
				return productRepository.save(p);
			}
		

}
