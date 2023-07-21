package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.dto.CVDto;

import java.util.List;

public interface CVService {
List<CVDto> findAll();
CVDto addCV(CVDto cv);
CVDto updateCV(int id, CVDto cv);
void delete(int id);
CVDto findById(int id);

}
