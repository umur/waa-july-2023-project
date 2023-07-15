package com.blue.alumniMangePortal.service.impl;

import com.blue.alumniMangePortal.repository.FacultyRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class FacultyUserDetailsService implements UserDetailsService {
    private final FacultyRepo facultyRepo;

    public FacultyUserDetailsService(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var faculty = facultyRepo.findByEmail(username);
        return new FacultyUserDetails(faculty.get());
    }
}
