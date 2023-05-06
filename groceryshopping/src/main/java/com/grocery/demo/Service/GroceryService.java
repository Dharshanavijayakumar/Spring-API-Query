package com.grocery.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.grocery.demo.Model.Grocery;
import com.grocery.demo.Repository.GroceryRepository;

import jakarta.transaction.Transactional;
	
	@Service
	public class GroceryService {

		@Autowired
		GroceryRepository grosRepository;
		public List<Grocery>getAllDetails(){
			List<Grocery>grosList=grosRepository.findAll();
			return grosList;
			
		}
		public Grocery saveGrocerys(Grocery s)
		{
			Grocery obj=grosRepository.save(s);
			return obj;
		}

		public Grocery updateDetails(Grocery s)
		{
			Grocery obj= grosRepository.save(s);
			return obj;
			//return studRepository.save(s);
			
			
		}
		public void deleteDetails(int s_no)
		{
			grosRepository.deleteById(s_no);
		}
		public Grocery getDetails(int s_no) {
			Grocery s=grosRepository.findById(s_no).get();
			return s;
		}
		public  List<Grocery> sortGrocery(String field) {
			
			return grosRepository.findAll(Sort.by(field));
			//return grosRepository.findAll(Sort.by(Direction.DESC,field));
		}
		public List<Grocery> pagingGrocery(int offset, int pageSize) {
				Pageable paging=PageRequest.of(offset, pageSize);
				Page<Grocery> grosData=grosRepository.findAll(paging);
				List<Grocery> grosList=grosData.getContent();
				return grosList;
				
		}
		public List<Grocery> pagingAndSortingGrocery(int offset, int pageSize, String field) {
				Pageable paging = PageRequest.of(offset, pageSize).withSort(Sort.by(field));
				Page<Grocery> gros=grosRepository.findAll(paging);
				return gros.getContent();
				}
		
		
		
		/*public List<Grocery> fetchGroceryByItemPrefix(String prefix)
		{
			return grosRepository.findByItemStartingWith(prefix);
		}
		
		
		public List<Grocery> fetchGroceryByItemSuffix(String suffix)
		{
			return grosRepository.findByItemEndingWith(suffix);
		}*/
		
		public List<Grocery> getGroceryByPrice(String pri, String item) 
		{
			return grosRepository.getGroceryByPrice(pri, item);
		}
		
		@Transactional
		public int deleteStudentByItem(String item)
		{
			return grosRepository.deleteGroceryByItem(item);
		}
		@Transactional
		public int updateGroceryByItem(String pri, String item) 
		{
			return grosRepository.updateGroceryByItem(pri,item);
		}
		

}
