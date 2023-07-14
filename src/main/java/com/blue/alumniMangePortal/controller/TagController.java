package com.blue.alumniMangePortal.controller;

import com.blue.alumniMangePortal.entity.Tag;
import com.blue.alumniMangePortal.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;

    @PostMapping("/tags")
    public Tag defineTag(Tag tag){
        tagService.addTag(tag);
        return tag;
    }
    @GetMapping("/tags")
    public List<Tag> getAllTags(){
        return tagService.getAllTags();
    }
}
