package com.security.app.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.security.app.daos.Userdao;
import com.security.app.dtos.Signinres;
import com.security.app.model.Appuser;
import com.security.app.userdetails.CustomUserDetails;

//here implements userdetailsservice interface 
//and implement the loadbyusername method 
@Service
public class UserserviceImp implements UserDetailsService {

	//now here autowired the dependency first 
	@Autowired
	private Userdao userDao;
	@Autowired
	private PasswordEncoder passwordencoder;
	
	//this method gives as userdetails 
	//nothing but all information about user
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Appuser users=userDao.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Invalid Email"));
		return new CustomUserDetails(users);
	}

	public String signupuser(Appuser user) {
	Appuser user1=new Appuser();
	user1.setEmail(user.getEmail());
	user1.setMobile(user.getMobile());
	user1.setRole(user.getRole());
	user1.setPassword(passwordencoder.encode(user.getPassword()));

		if(user!=null) {
			userDao.save(user1);
		return "success";
		}
		else
			return "fail";
	}
}
