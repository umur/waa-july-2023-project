package com.alumni.Service.impls;

import com.alumni.Exceptions.NotFoundException;
import com.alumni.Service.BaseUserService;
import com.alumni.Service.FacultyService;
import com.alumni.dtos.request.FacultyRequestDto;
import com.alumni.dtos.response.FacultyResponseDTO;
import com.alumni.entity.Faculty;
import com.alumni.entity.Role;
import com.alumni.repository.FacultyRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class FacultyServiceImpl implements FacultyService {
    private final ModelMapper modelMapper;

    private final FacultyRepository repository;

    private final BaseUserService baseUserService;
    @Override
    public List<FacultyResponseDTO> getList(int page, int size, String name) {


    return repository.findAllByNameContainsIgnoreCaseOrderByIdDesc(
            name,
                    PageRequest.of(page,size)
                    )
                    .stream().map((Faculty faculty)->modelMapper.map(faculty,FacultyResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void create(FacultyRequestDto requestDto) {
        Faculty entity= modelMapper.map(requestDto,Faculty.class);
        entity.setUser(baseUserService.save(requestDto.getEmail(), requestDto.getEmail(),List.of(Role.FACULTY)));
        repository.save(entity);

    }

    @Override
    public FacultyResponseDTO findById(Long id) {
        Faculty entity=getByID(id);
        return modelMapper.map(entity,FacultyResponseDTO.class);
    }

    private Faculty getByID(Long id){
        return repository.findById(id).orElseThrow(()->new NotFoundException("Faculty with ID: " +id +" was not found"));
    }

    @Override
    public void put(Long id, FacultyRequestDto requestDto) {
        Faculty source=getByID(id);
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
        Faculty faculty=getByID(id);

        baseUserService.changePassword(faculty.getUser(),password);
    }
}
