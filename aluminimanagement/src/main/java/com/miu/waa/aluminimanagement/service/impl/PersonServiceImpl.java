package com.miu.waa.aluminimanagement.service.impl;

import com.miu.waa.aluminimanagement.helper.EmailService;
import com.miu.waa.aluminimanagement.model.Address;
import com.miu.waa.aluminimanagement.model.Person;
import com.miu.waa.aluminimanagement.model.dto.PersonDto;
import com.miu.waa.aluminimanagement.repository.AddressRepo;
import com.miu.waa.aluminimanagement.repository.FacultyRepo;
import com.miu.waa.aluminimanagement.repository.PersonRepo;
import com.miu.waa.aluminimanagement.repository.StudentRepo;
import com.miu.waa.aluminimanagement.security.MyUserDetails;
import com.miu.waa.aluminimanagement.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepo personRepo;
    private final StudentRepo studentRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

   private final JavaMailSender javaMailSender;

    private final ModelMapper modelMapper;
    private final String STUDENT_ROLE = "Student";
    private final String FACULTY_ROLE = "Faculty";
    private final String ADMIN_ROLE = "Admin";

    private final FacultyRepo facultyRepo;
    private final AddressRepo addressRepo;
    @Override
    public PersonDto findById() {
        PersonDto personDto = new PersonDto();
        int userId = ((MyUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal()).getUserId();
        Person person = personRepo.findById(userId).get();
        if (person.getRoles().stream().findFirst().get().getRole().equalsIgnoreCase(STUDENT_ROLE)) {
            personDto = modelMapper.map(studentRepo.findById(userId).get(), PersonDto.class);
        } else if (person.getRoles().stream().findFirst().get().getRole().equalsIgnoreCase(FACULTY_ROLE)) {
            personDto = modelMapper.map(facultyRepo.findById(userId).get(), PersonDto.class);
        } else if (person.getRoles().stream().findFirst().get().getRole().equalsIgnoreCase(ADMIN_ROLE)) {
            personDto = modelMapper.map(personRepo.findById(userId).get(), PersonDto.class);
        }
        return personDto;
    }

    @Override
    public PersonDto getById(int id) {
        var person= personRepo.findById(id).orElseThrow(()->new RuntimeException("Person Not Found."));
        return modelMapper.map(person, PersonDto.class);
    }

    @Override
    public String sendPasswordResetEmail(int id, String recipient) {
        System.out.println("Hi............");
        EmailService emailService = new EmailService(javaMailSender);
        String password = "12345";
        Person person = personRepo.findById(id).get();
        person.setPassword(bCryptPasswordEncoder.encode(password));
        personRepo.save(person);
        String message1 = "Your password has been reset successfully";
        String message2 = "Your new password is".concat(password).concat(". Change it after logging in.");
        String finalMessage = message1.concat(" "+message2);
        return emailService.sendEmail(recipient,"Password Reset",finalMessage);

    }

    @Override
    public void updateAddress(int id, Address address) {
        Person person = personRepo.findById(id).orElseThrow(() -> new RuntimeException("Person Not Found."));
        if (person.getAddress()!=null){
        Address address1 = addressRepo.findById(person.getAddress().getId()).get();

            address1.setCity(address.getCity());
            address1.setZip(address.getZip());
            address1.setState(address.getState());
            address1.setStreet(address.getStreet());

            Address add = addressRepo.save(address1);
            person.setAddress(add);
            personRepo.save(person);
        } else {
            Address savedAddress = addressRepo.save(address);
            person.setAddress(savedAddress);

            personRepo.save(person);

        }



    }

    @Override
    public void changeStatus(int id, Boolean status) {
        Person person = personRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        person.setActive(status);
        person.setId(id);
        personRepo.save(person);
    }
    @Override
    public List<Person> findAll() {
        return personRepo.findAll();
    }
}
