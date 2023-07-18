package com.twohundred.alumni.service;

import java.util.List;

import com.twohundred.alumni.entity.CV;
import com.twohundred.alumni.entity.CVId;
import com.twohundred.alumni.entity.dto.request.CVDto;

public interface CVService {
    List<CVDto> getCVs(Long id);

    CV findById(CVId cvId);

    CVDto create(CVDto cv);

    CVDto update(CVDto cv);

    CVDto delete(CVId cvId);
}
