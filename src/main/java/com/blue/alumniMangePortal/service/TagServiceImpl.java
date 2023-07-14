package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Tag;
import com.blue.alumniMangePortal.repository.TagRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService{
    private final TagRepo tagRepo;

    public List<Tag> getAllTags(){
       return tagRepo.findAll();
    }

    public Tag addTag(Tag tag){
         tagRepo.save(tag);
         return tag;
    }
}
