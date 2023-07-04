package com.example.alumni.service.impl;

import com.example.alumni.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.Tag;
import com.example.alumni.repository.TagRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Iterable<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagById(long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Pair<Boolean, Tag> updateTag(Tag tag) {
        boolean exists = tagRepository.existsById(tag.getId());
        tagRepository.save(tag);
        return Pair.of(exists, tag);
    }
    @Override
    public boolean deleteTag(long id) {
        Tag existingTag = tagRepository.findById(id).orElse(null);
        if (existingTag != null) {
            tagRepository.delete(existingTag);
            return true;
        }
        return false;
    }
}
