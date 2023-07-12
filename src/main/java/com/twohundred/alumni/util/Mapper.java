package com.twohundred.alumni.util;

import com.twohundred.alumni.entity.JobAdvertisement;
import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.dto.request.AddressDto;
import com.twohundred.alumni.entity.dto.request.JobAdvertisementDto;
import com.twohundred.alumni.entity.dto.request.StudentDto;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public StudentDto mapStudentToDTO(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setEmail(student.getEmail());
        studentDto.setEmail(student.getEmail());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        studentDto.setGpa(student.getGpa());
        studentDto.setMajor(student.getMajor());
        studentDto.setAddress(new AddressDto());
        studentDto.getAddress().setCity(student.getAddress().getCity());
        studentDto.getAddress().setState(student.getAddress().getState());
        studentDto.getAddress().setStreet(student.getAddress().getStreet());
        studentDto.getAddress().setZip(student.getAddress().getZip());
        return studentDto;
    }

    public JobAdvertisementDto mapJobAdToFilteredDTO(JobAdvertisement job) {
        return new JobAdvertisementDto(job.getId(), job.getDescription(), job.getBenefits(), job.getCompanyName(), job.getState(),
                job.getCity(), job.getTags(), job.getFaculty().getId(), job.getFiles(), Utils.dateLongToString(job.getDateCreated().getTime()));
    }

}
