package com.smoke.screen.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoke.screen.entities.User;
import com.smoke.screen.exceptions.ApiException;
import com.smoke.screen.security.JwtTokenHelper;
import com.smoke.screen.utilities.JwtAuthRequest;
import com.smoke.screen.utilities.JwtAuthResponse;

@RestController
@RequestMapping("/v1/api/auth/")
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenhelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		this.authenticate(request.getUsername(), request.getPassword());
		UserDetails user = this.userDetailsService.loadUserByUsername(request.getUsername());
		String token = this.jwtTokenhelper.generateToken(user);
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(token);
		response.setUser(this.modelMapper.map((User) user, User.class));
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);
	}

	private void authenticate(String username, String password) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		try {
			this.authenticationManager.authenticate(authenticationToken);
		}
		catch (BadCredentialsException ex) {
			System.out.println("Invalid Login Details!");
			throw new ApiException("Invalid Login Details");
		}
		
		
	}
}
