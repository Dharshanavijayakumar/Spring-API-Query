package com.grocery.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.demo.Model.Grocery;
import com.grocery.demo.Service.GroceryService;

import io.swagger.v3.oas.annotations.tags.Tag;
@RestController

public class GroceryController {

	@Autowired
	GroceryService grosService;
	@Tag(name="Get",description="get data")
	@GetMapping(value="fetchDetails")
	public List<Grocery> getAllDetails(){
		List<Grocery> grosList=grosService.getAllDetails();
		return grosList;
	}
	@Tag(name="Post",description="post data")
	@PostMapping(value="/saveDetails")
	public Grocery saveDetails(@RequestBody Grocery s)
	{
		return grosService.saveGrocerys(s);
	}
	@Tag(name="Put",description="put data")
	@PutMapping(value="/updateDetails")
	 public Grocery updateDetails(@RequestBody Grocery s) 
		{
			return grosService.saveGrocerys(s);
			
		}
	
	@Tag(name="Delete",description="delete data")
	 @DeleteMapping(value="/deleteDetails/{s_no}") 
	 public void  deleteDetails(@PathVariable("s_no") int s_no)
	 {
	 	grosService.deleteDetails(s_no);
	 }
	 @GetMapping(value="/getDetails/{s_no}")
	 public Grocery getDetails(@PathVariable("s_no")  int s_no)
	 {
	 	return grosService.getDetails(s_no);
	 }
	 @GetMapping("/sortGrocery/{field}")
	 public List<Grocery> sortGrocery(@PathVariable String field)
	 {
		 return grosService.sortGrocery(field);
	 }
	 @GetMapping("/pagingGrocery/{offset}/{pageSize}")
	 public List<Grocery> pagingGrocery(@PathVariable int offset,@PathVariable int pageSize)
	 {
		 return grosService.pagingGrocery(offset,pageSize);
	 }
	 @GetMapping("/pagingAndSortingGrocery/{offset}/{pageSize}/{field}")

	 public List<Grocery> pagingAndSortingGrocery(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field) 
	 {
	 	return grosService.pagingAndSortingGrocery(offset, pageSize, field);
	 	
	 }
	 
	 
	 /*@GetMapping("/fetchGroceryByItemPrefix")
	 public List<Grocery>fetchGroceryByItemPrefix(@RequestParam String prefix)
	 {
		 return grosService.fetchGroceryByItemPrefix(prefix);
	 }
	 
	 
	 @GetMapping("/fetchGroceryByItemSuffix")
	 public List<Grocery>fetchGroceryByItemSuffix(@RequestParam String suffix)
	 {
		 return grosService.fetchGroceryByItemSuffix(suffix);
	 }*/
	 
	 
	 
	 @GetMapping("/fetchGroceryByPrice/{pri}/{item}")
	 public List<Grocery>fetchgetGroceryByPrice(@PathVariable String pri,@PathVariable String item)
	 {
		 return grosService.getGroceryByPrice(pri,item);
	 }
	 
	 @DeleteMapping("/deleteGroceryByItem/{item}")
	 public String deleteGroceryByItem(@PathVariable String item)
	 {
	 int result=grosService.deleteStudentByItem(item);
	 if(result >0)
	 	return "Grocery record deleted";
	 else
	 	return "Problem occured while deleting";
	 }
	 
	 
	 
	 @GetMapping("/updateGroceryByItem/{pri}/{item}")
	 public String updateGroceryByItem(@PathVariable String pri,@PathVariable String item)
	 {
		 int result=grosService.updateGroceryByItem(pri,item);
	     if(result >0)
	     {
	         return "Grocery record updated";
	     }
	     else
	     {
	    	 return "Problem occured while updating";
	     }
	 }
	 
	 
	}
	




