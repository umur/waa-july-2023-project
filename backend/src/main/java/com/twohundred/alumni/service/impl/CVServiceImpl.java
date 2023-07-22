package com.twohundred.alumni.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.twohundred.alumni.entity.CV;
import com.twohundred.alumni.entity.CVId;
import com.twohundred.alumni.entity.dto.request.CVDto;
import com.twohundred.alumni.entity.dto.request.CVWithoutJobAdDto;
import com.twohundred.alumni.exception.Exceptions;
import com.twohundred.alumni.repository.CVRepo;
import com.twohundred.alumni.service.CVService;
import com.twohundred.alumni.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CVServiceImpl implements CVService {
    private final CVRepo cvRepo;
    private final JobAdvertisementServiceImpl jobAdService;
    private final StudentServiceImpl studentServiceImpl;
    private final ModelMapper modelMapper;
    private final SecurityUtil securityUtil;

    @Override
    public List<CVDto> getCVs(Long id) {
        List<CV> cvs = studentServiceImpl.findById(id).getCvs();

        return cvs.stream().map(cv -> modelMapper.map(cv, CVDto.class)).collect(Collectors.toList());
    }

    @Override
    public CV findById(CVId cvId) {
        Optional<CV> optionalCV = cvRepo.findById(cvId);

        if (!optionalCV.isPresent()) {
            throw Exceptions.CV_NOT_FOUND;
        }

        return optionalCV.get();
    }

    @Override
    public CVDto findByIdDto(CVId cvId) {
        CV cv = findById(cvId);
        return modelMapper.map(cv, CVDto.class);
    }

    @Override
    public CVDto findByIdDtoForCreator(CVId cvId) {
        CV cv = findById(cvId);

        if (!cv.getJobAd().getCreatedStudent().getId().equals(securityUtil.getCurrentUserId())) {
            throw Exceptions.CV_NOT_FOUND;
        }

        return modelMapper.map(cv, CVDto.class);
    }

    @Override
    public CVDto create(CVDto cvDto) {
        CV cv = modelMapper.map(cvDto, CV.class);
        cv.setCreatedDate(LocalDate.now());

        cv.setJobAd(jobAdService.getById(cv.getId().getJobAdId()));
        cv.setStudent(studentServiceImpl.findById(cv.getId().getStudentId()));

        CV temp = cvRepo.save(cv);
        return modelMapper.map(temp, CVDto.class);
    }

    @Override
    public CVDto update(CVDto cvDto) {
        CVId cvId = modelMapper.map(cvDto.getId(), CVId.class);
        CV cv = findById(cvId);
        cv.setText(cvDto.getText());

        CV temp = cvRepo.save(cv);
        return modelMapper.map(temp, CVDto.class);
    }

    @Override
    public CVDto delete(CVId cvId) {
        CV cv = findById(cvId);
        cvRepo.delete(cv);

        return modelMapper.map(cv, CVDto.class);
    }

}
