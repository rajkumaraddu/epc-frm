/**
 * 
 */
package com.mahindra.epcfrm.service;

import com.mahindra.epcfrm.entity.UserMasterEntity;
import com.mahindra.epcfrm.repository.UserMasterRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Raju.Addu
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMasterRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserMasterEntity user = userRepo.findByUserIdOrTokenNo(username,username);
        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), new ArrayList<>());
    }
}