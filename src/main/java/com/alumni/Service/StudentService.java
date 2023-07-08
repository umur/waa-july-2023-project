package com.alumni.Service;

import com.alumni.dtos.response.StudentResponseDTO;
import com.alumni.dtos.request.StudentRequestDto;
import com.alumni.entity.BaseUser;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getList(int page, int size, String state, String city, String major, String name);

    void create(StudentRequestDto requestDto);

    StudentResponseDTO findById(Long id);

     void put(Long id, StudentRequestDto requestDto);

    void deleteById(Long id);

     void changePassword(Long id, String password);
}
