package com.grocery.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.demo.Model.Login;
import com.grocery.demo.Service.LoginService;

@RestController
public class LoginController {
@Autowired
LoginService loginService;
@PostMapping("/checkLogin")
	public String validateUser(@RequestBody Login u)
	{
	System.out.println(u.getUsername());
		return loginService.validateUser(u.getUsername(),u.getPassword());
	}
@PostMapping("/addUser")
public Login saveUser(@RequestBody Login u)
{
return loginService.saveUser(u);
}
}


