package com.twohundred.alumni.util;

import com.twohundred.alumni.entity.JobAdvertisement;
import com.twohundred.alumni.entity.Student;
import com.twohundred.alumni.entity.dto.request.JobAdvertisementDto;
import com.twohundred.alumni.entity.dto.request.StudentDto;

public class Mapper {
    public StudentDto mapStudentToDTO(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.getUser().setEmail(student.getUser().getEmail());
        studentDto.getUser().setFirstName(student.getUser().getFirstName());
        studentDto.getUser().setLastName(student.getUser().getLastName());
        studentDto.setGpa(student.getGpa());
        studentDto.getUser().getAddress().setCity(student.getUser().getAddress().getCity());
        studentDto.getUser().getAddress().setState(student.getUser().getAddress().getState());
        return studentDto;
    }

    public JobAdvertisementDto mapJobAdToFilteredDTO(JobAdvertisement job) {
        return new JobAdvertisementDto(job.getId(), job.getDescription(), job.getBenefits(), job.getCompanyName(), job.getState(),
                job.getCity(), job.getTags(), job.getFaculty().getId(), job.getFiles(), Utils.dateLongToString(job.getDateCreated().getTime()));
    }

}
