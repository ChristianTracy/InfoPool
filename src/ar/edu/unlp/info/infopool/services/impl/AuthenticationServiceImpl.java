package ar.edu.unlp.info.infopool.services.impl;

import org.springframework.stereotype.Component;

import ar.edu.unlp.info.infopool.services.AuthenticationService;
@Component
public class AuthenticationServiceImpl implements AuthenticationService{

	@Override
	public void printTest() {
		System.out.println("in auth service");
	}

}
