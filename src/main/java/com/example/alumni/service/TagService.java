package com.example.alumni.service;

import com.example.alumni.entity.Tag;
import org.springframework.data.util.Pair;

public interface TagService {
    Iterable<Tag> getAllTags();

    Tag getTagById(long id);

    Tag createTag(Tag tag);

    Pair<Boolean, Tag> updateTag(Tag tag);

    boolean deleteTag(long id);
}
