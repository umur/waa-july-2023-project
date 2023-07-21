package com.miu.waa.aluminimanagement.service.impl;

import com.miu.waa.aluminimanagement.model.Faculty;
import com.miu.waa.aluminimanagement.model.Role;
import com.miu.waa.aluminimanagement.model.Student;
import com.miu.waa.aluminimanagement.model.dto.LoginRequest;
import com.miu.waa.aluminimanagement.model.dto.LoginResponse;
import com.miu.waa.aluminimanagement.model.dto.RegisterDto;
import com.miu.waa.aluminimanagement.model.dto.RoleDto;
import com.miu.waa.aluminimanagement.repository.RoleRepo;
import com.miu.waa.aluminimanagement.security.JwtHelper;
import com.miu.waa.aluminimanagement.security.MyUserDetails;
import com.miu.waa.aluminimanagement.service.FacultyService;
import com.miu.waa.aluminimanagement.service.StudentService;
import com.miu.waa.aluminimanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;
    private final ModelMapper modelMapper;
    private final StudentService studentService;
    private final FacultyService facultyService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RoleRepo roleRepo;

    private final String STUDENT_ROLE = "Student";
    private final String FACULTY_ROLE =  "Faculty";
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication result;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
            throw e;
        } catch (Exception ex) {
            log.info(ex.getMessage());
            throw ex;
        }
        final String accessToken = jwtHelper.generateToken(loginRequest.getUsername(),
                new HashMap<String, Object>() {{
                    put("firstname", ((MyUserDetails) result.getPrincipal()).getFirstname());
                    put("lastname", ((MyUserDetails) result.getPrincipal()).getLastname());
                    put("sub", loginRequest.getUsername());
                    put("userId",((MyUserDetails) result.getPrincipal()).getUserId());
                    put("rol",((MyUserDetails) result.getPrincipal()).getRoles());
                }}
        );
        var loginResponse = new LoginResponse(accessToken);
        return loginResponse;
    }

    @Override
    public void register(RegisterDto person) {
        decoratePerson(person);
        if(person.getRole().getRole().equalsIgnoreCase(STUDENT_ROLE)){
            registerStudent(person);
        }else if(person.getRole().getRole().equalsIgnoreCase(FACULTY_ROLE)){
            registerFaculty(person);
        }
    }

    private void registerStudent(RegisterDto person){
        Student student =  modelMapper.map(person, Student.class);//not beig mapped by modelMapper
        studentService.save(student);
    }

    private void registerFaculty(RegisterDto person){
        Faculty faculty = modelMapper.map(person, Faculty.class);
        facultyService.save(faculty);
    }

    private void decoratePerson(RegisterDto person){
        String password = person.getPassword();
        person.setPassword(bCryptPasswordEncoder.encode(password));
        person.setRoles(new ArrayList<>(Arrays.asList(person.getRole())));
    }

    public List<RoleDto> findAllRoles()
    {

        return roleRepo.findAll().stream().filter(r->!r.isDeleted()).filter(r->!"Admin".equals(r.getRole())).map(p -> modelMapper.map(p, RoleDto.class)).toList();
    }

    private List<RoleDto> mapListofRole(List<Role> roles)
    {
        List<RoleDto> rolesDto = new ArrayList<>();
        for(Role role:roles){
            RoleDto dto = new RoleDto();
            dto.setId(role.getId());
            dto.setRole(role.getRole());
            rolesDto.add(dto);
        }
        return rolesDto;
//        return roles.stream().map(r->modelMapper.map(r,RoleDto.class)).toList();
    }
}
