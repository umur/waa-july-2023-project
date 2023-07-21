package com.miu.waa.aluminimanagement.security;

import com.miu.waa.aluminimanagement.model.Person;
import com.miu.waa.aluminimanagement.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final PersonRepo personRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personRepo.findPersonByUsernameIgnoreCase(username);
        var userDetails = new MyUserDetails(person);
        return userDetails;
    }
}
