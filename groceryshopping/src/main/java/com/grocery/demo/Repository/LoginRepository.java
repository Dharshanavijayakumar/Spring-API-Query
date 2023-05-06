package com.grocery.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grocery.demo.Model.Login;


	@Repository
	public interface LoginRepository extends JpaRepository<Login,Integer>{
		Login findByUsername(String username);

	}



