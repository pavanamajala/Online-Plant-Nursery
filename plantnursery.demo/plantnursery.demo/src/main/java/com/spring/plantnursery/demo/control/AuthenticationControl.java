package com.spring.plantnursery.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.plantnursery.demo.entity.AuthenticationRequest;
import com.spring.plantnursery.demo.service.MyUserDetailsService;
import com.spring.plantnursery.demo.utils.JwtUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationControl {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	
	@Autowired
	private JwtUtil jwt;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String createAuthenticationToken(@RequestBody AuthenticationRequest auth ) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUserName(), auth.getPassword()));
			
		} catch(BadCredentialsException e) {
			return null;
		}
		
		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(auth.getUserName());
		return jwt.generateToken(userDetails);
	}
	

}
