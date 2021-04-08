/**
 * 
 */
package com.mahindra.epcfrm.service;

import com.mahindra.epcfrm.entity.UserMasterEntity;
import com.mahindra.epcfrm.repository.UserMasterRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * @author Raju.Addu
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserMasterRepo userRepo;

	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserMasterEntity user = userRepo.findByMobile(username);
		logger.info(user.getMobile() + " >>>> " + user.getPassword());
		if(LocalDateTime.now().isAfter(user.getPwdValidity())) {
			return new org.springframework.security.core.userdetails.User(user.getMobile(), null,
					new ArrayList<>());
		}
		return new org.springframework.security.core.userdetails.User(user.getMobile(), user.getPassword(),
				new ArrayList<>());
	}
}