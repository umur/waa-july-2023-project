package com.example.alumni.controller;

import com.example.alumni.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.alumni.entity.Tag;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<Iterable<Tag>> getAll() {
        Iterable<Tag> tags = tagService.getAll();
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STUDENT') or hasAuthority('FACULTY')")
    public ResponseEntity<Tag> getById(@PathVariable long id) {
        Tag tag = tagService.getById(id);
        if (tag != null) {
            return new ResponseEntity<>(tag, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search")
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<List<Tag>> getBySearch(@RequestParam String tag) {
        return new ResponseEntity<>(tagService.getAllByTag(tag), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<Tag> add(@RequestBody Tag tag) throws IllegalAccessException {
        Tag createdTag = tagService.add(tag);
        return new ResponseEntity<>(createdTag, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Tag> update(@PathVariable long id, @RequestBody Tag tag) throws IllegalAccessException {
        Pair<Boolean, Tag> result = tagService.update(tag);
        return (!result.getFirst())
                ? new ResponseEntity<>(result.getSecond(), HttpStatus.CREATED)
                : new ResponseEntity<Tag>(result.getSecond(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable long id) throws IllegalAccessException {
        boolean deleted = tagService.delete(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
