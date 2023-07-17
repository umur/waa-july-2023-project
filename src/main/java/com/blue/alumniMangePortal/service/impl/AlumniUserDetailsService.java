package com.blue.alumniMangePortal.service.impl;

import com.blue.alumniMangePortal.repository.AlumniUserRepo;
import com.blue.alumniMangePortal.repository.FacultyRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
@Transactional
public class AlumniUserDetailsService implements UserDetailsService {
//    private final FacultyRepo facultyRepo;
private final AlumniUserRepo alumniUserRepo;
    public AlumniUserDetailsService(AlumniUserRepo alumniUserRepo) {
        this.alumniUserRepo = alumniUserRepo;
//        this.facultyRepo = facultyRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var faculty = alumniUserRepo.findByEmail(username);
        return new AlumniUserDetails(faculty.get());
    }
}
