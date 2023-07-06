package com.example.alumni.service;

import com.example.alumni.entity.Tag;

import java.util.List;

public interface TagService extends BaseService<Tag, Long> {
    List<Tag> getAllByTag(String tag);
}
