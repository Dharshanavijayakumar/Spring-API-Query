package com.grocery.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.demo.Model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> 


 
{

}



