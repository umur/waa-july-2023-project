package com.example.alumni.service.impl;

import com.example.alumni.entity.Role;
import com.example.alumni.entity.UniversityMember;
import com.example.alumni.entity.dto.request.ResetUserPasswordRequest;
import com.example.alumni.entity.dto.request.ToggleUserStatusRequest;
import com.example.alumni.service.RoleService;
import com.example.alumni.service.UniversityMemberService;
import com.example.alumni.service.UserService;
import com.example.alumni.util.CurrentUserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.User;
import com.example.alumni.repository.UserRepository;

import org.springframework.data.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UniversityMemberService universityMemberService;

    @Autowired
    private CurrentUserUtil currentUserUtil;


    @Override
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User add(User user) throws IllegalAccessException {
        Optional<User> existingUser = userRepository.findByEmail(user.getEmail());
        if (!existingUser.isPresent()) {
            Optional<UniversityMember> universityMember = universityMemberService.getByEmail(user.getEmail());
            if (universityMember.isPresent()) {
                List<Role> roles = new ArrayList<>();
                roles.add(roleService.getByRole(universityMember.get().getRole()));
                user.setRoles(roles);
                String salt = BCrypt.gensalt();
                user.setPassword(BCrypt.hashpw(user.getPassword(), salt));
                return userRepository.save(user);
            } else {
                throw new IllegalAccessException("You are not a member of MIU");
            }
        } else {
            throw new IllegalArgumentException("Email already in use");
        }
    }

    @Override
    public Pair<Boolean, User> update(User user) throws IllegalAccessException {
        Optional<User> existingUser = userRepository.findById(user.getId());
        if (existingUser.isPresent()) {
            User userForUpdate = existingUser.get();
            if (currentUserUtil.getUserId().get() != userForUpdate.getId()) {
                throw new IllegalAccessException("Only owner can edit");
            }
            userForUpdate.setFirstName(user.getFirstName());
            userForUpdate.setLastName(user.getLastName());
            // existingUser.setEmail(user.getEmail());
            // existingUser.setPassword(user.getPassword());
            user = userRepository.save(userForUpdate);
        }
        return Pair.of(existingUser.isPresent(), user);
    }

    @Override
    public boolean delete(Long id) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            userRepository.delete(existingUser);
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllByMajor(String major) {
        return userRepository.findByMajor(major);
    }

    @Override
    public List<User> getAllByState(String state) {
        return userRepository.findByState(state);
    }

    @Override
    public List<User> getAllByCity(String city) {
        return userRepository.findByCity(city);
    }

    @Override
    public User toggleUserStatus(ToggleUserStatusRequest toggleUserStatusRequest) {
        Optional<User> existingUser = userRepository.findById(toggleUserStatusRequest.getUserId());
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            boolean hasStudentOrFacultyRole = user.getRoles().stream()
                    .anyMatch(role -> role.getRole().equals("STUDENT") || role.getRole().equals("FACULTY"));
            if (hasStudentOrFacultyRole) {
                user.setEnabled(toggleUserStatusRequest.getEnabled());
                user = userRepository.save(user);
                return user;
            } else {
                throw new IllegalArgumentException("Admin can toggle status for STUDENT OR FACULTY only.");
            }

        }
        throw new IllegalArgumentException("User does not exist");
    }

    @Override
    public User resetUserPassword(ResetUserPasswordRequest resetUserPasswordRequest) {
        Optional<User> existingUser = userRepository.findById(resetUserPasswordRequest.getUserId());
        if (existingUser.isPresent()) {
            User user = existingUser.get();

            boolean hasStudentOrFacultyRole = user.getRoles().stream()
                    .anyMatch(role -> role.getRole().equals("STUDENT") || role.getRole().equals("FACULTY"));
            if (hasStudentOrFacultyRole) {
                String salt = BCrypt.gensalt();

                user.setPassword(BCrypt.hashpw(resetUserPasswordRequest.getPassword(), salt));
                user = userRepository.save(user);
                return user;
            } else {
                throw new IllegalArgumentException("Admin can reset password for STUDENT OR FACULTY only.");
            }
        }
        throw new IllegalArgumentException("User does not exist");
    }
}
