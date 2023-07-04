package com.alumni.Service.impls;

import com.alumni.Service.BaseUserService;
import com.alumni.entity.BaseUser;
import com.alumni.entity.Role;
import com.alumni.repository.BaseUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class BaseUserServiceImpl implements BaseUserService {

private final BaseUserRepository repository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    @Override
    public BaseUser save(String email, String password, List<Role> roles) {

        BaseUser baseUser= new BaseUser();
        baseUser.setEmail(email);
        baseUser.setPassword(bCryptPasswordEncoder.encode(password));
        baseUser.setActiveAfter(LocalDateTime.now());
        baseUser.setActive(true);
        baseUser.setFailedLoginAttempts(0);
        baseUser.setRoles(roles);

        return repository.save(baseUser);
    }

    @Override
    public void changePassword(BaseUser user,String password) {
        user.setPassword(bCryptPasswordEncoder.encode(password));
        repository.save(user);
    }
}
