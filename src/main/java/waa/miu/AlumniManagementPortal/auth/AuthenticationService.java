package waa.miu.AlumniManagementPortal.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.configuration.JwtService;
import waa.miu.AlumniManagementPortal.entity.AlumniUser;
import waa.miu.AlumniManagementPortal.repository.AlumniUserRepo;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AlumniUserRepo alumniUserRepo;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    //    private final StudentRepo studentRepo;
    private final UserDetailsService userDetailsService;

    public AuthenticationResponse registerFaculty(RegisterRequest request) {
//        String role = request.getRole();
//        var al =
        var alumniUser = AlumniUser.builder()
                .firstName(request.getFirst_name())
                .lastName(request.getLast_name())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
//                .phone_number(request.getPhone_number())
//                .department(request.getDepartment())
//                .title(request.getTitle())
//                .comments(request.getComments())
//                .address(request.getAddress())
//                .is_admin(true)
//                .is_deleted(false)
                .role(request.getRole())
                .build();
        alumniUserRepo.save(alumniUser);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(alumniUser.getEmail());
        var jwtToken = jwtService.generateToken(userDetails);
        System.out.println(jwtToken);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication result = null;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }
//        var faculty = facultyRepo.findByEmail(request.getEmail())
//                .orElseThrow();
        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());
        var jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
