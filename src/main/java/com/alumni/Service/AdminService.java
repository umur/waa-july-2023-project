package com.alumni.Service;

import com.alumni.dtos.request.AdminRequestDto;
import com.alumni.dtos.response.AdminResponseDTO;
import com.alumni.entity.Admin;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface AdminService {
    List<AdminResponseDTO> getList(int page, int size, String name);

    void create(AdminRequestDto requestDto);

    AdminResponseDTO findById(Long id);

     void put(Long id, AdminRequestDto requestDto);

    void deleteById(Long id);

     void changePassword(Long id, String password);


}
