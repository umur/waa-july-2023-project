package waa.miu.AlumniManagementPortal.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import waa.miu.AlumniManagementPortal.repository.AlumniUserRepo;

@Service("userDetailsService")
@Transactional
public class AlumniUserDetailsService implements UserDetailsService {
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
