package com.example.alumni.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.alumni.entity.Tag;
import com.example.alumni.repository.TagRepository;

import org.springframework.data.util.Pair;

@Service
@Transactional
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public Iterable<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag getTagById(long id) {
        return tagRepository.findById(id).orElse(null);
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Pair<Boolean, Tag> updateTag(Tag tag) {
        boolean exists = tagRepository.existsById(tag.getId());
        tagRepository.save(tag);
        return Pair.of(exists, tag);
    }

    public boolean deleteTag(long id) {
        Tag existingTag = tagRepository.findById(id).orElse(null);
        if (existingTag != null) {
            tagRepository.delete(existingTag);
            return true;
        }
        return false;
    }
}
