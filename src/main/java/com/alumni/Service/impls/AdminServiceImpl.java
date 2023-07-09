package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.AdminService;
import com.alumni.Service.BaseUserService;
import com.alumni.Service.StudentService;
import com.alumni.dtos.request.AdminRequestDto;
import com.alumni.dtos.response.AdminResponseDTO;
import com.alumni.dtos.response.StudentResponseDTO;
import com.alumni.entity.Admin;
import com.alumni.entity.Role;
import com.alumni.entity.Student;
import com.alumni.repository.AdminRepository;
import com.alumni.repository.StudentRepository;
import com.alumni.utils.RepositoryUtils;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final ModelMapper modelMapper;

    private final AdminRepository repository;

    private final BaseUserService baseUserService;
    @Override
    public List<AdminResponseDTO> getList(int page, int size,  String name) {


    return repository.findAllByNameContainsIgnoreCaseOrderByIdDesc( name,PageRequest.of(page,size)
                    )
                    .stream().map((Admin admin)->modelMapper.map(admin,AdminResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void create(AdminRequestDto requestDto) {
        Admin entity= modelMapper.map(requestDto,Admin.class);
        entity.setUser(baseUserService.save(requestDto.getEmail(), requestDto.getEmail(),List.of(Role.STUDENT)));
        repository.save(entity);

    }

    @Override
    public AdminResponseDTO findById(Long id) {
        Admin entity=getByID(id);
        return modelMapper.map(entity, AdminResponseDTO.class);
    }

    private Admin getByID(Long id){
        return repository.findById(id).orElseThrow(()->new NotFoundException("Admin with ID: " +id +" was not found"));
    }

    @Override
    public void put(Long id, AdminRequestDto requestDto) {
        Admin source=getByID(id);
        modelMapper.map(requestDto,source);
        source.setId(id);
        repository.save(source);
    }

    @Override
    public void deleteById(Long id) {
         repository.deleteById(id);

    }

    @Override
    public void changePassword(Long id, String password) {
        Admin entity=getByID(id);

        baseUserService.changePassword(entity.getUser(),password);
    }
}
