package com.grocery.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.grocery.demo.Model.Grocery;


	public interface GroceryRepository extends JpaRepository<Grocery,Integer>
	{
		//positional parameter means ? come (order match)
		
			@Query("select s from  Grocery s where s.price=?1 and s.item=?2")
			public List<Grocery> getGroceryByPrice(String pri,String item);
			
			//named parameter
			
			@Query("select s from Grocery s where s.price=:price")
			public List<Grocery> getGroceryByPrice(String pri);
			

			
			//DML parameter
			@Modifying
			
			@Query("delete from Grocery s where s.item=?1")
			public int deleteGroceryByItem(String item);
			
			@Modifying
			@Query("update Grocery s set s.price=?1 where s.item=?2")
			public int updateGroceryByItem(String pri,String item);
			
			

}
