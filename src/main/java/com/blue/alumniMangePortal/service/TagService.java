package com.blue.alumniMangePortal.service;

import com.blue.alumniMangePortal.entity.Tag;

import java.util.List;

public interface TagService {
     List<Tag> getAllTags();
     Tag addTag(Tag tag);
}
