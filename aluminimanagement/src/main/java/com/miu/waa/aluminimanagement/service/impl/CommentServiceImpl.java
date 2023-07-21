package com.miu.waa.aluminimanagement.service.impl;

import com.miu.waa.aluminimanagement.model.Comment;
import com.miu.waa.aluminimanagement.model.Faculty;
import com.miu.waa.aluminimanagement.model.dto.CommentDto;
import com.miu.waa.aluminimanagement.repository.CommentRepo;
import com.miu.waa.aluminimanagement.service.CommentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {
private final CommentRepo commentRepo;
private final ModelMapper modelMapper;
/*
the findAll() method retrieves all comments from a repository, filters out deleted comments,
maps the remaining comments to CommentDto objects using a mapping library, and returns the
resulting list of CommentDto objects.
* */
    @Override
    public List<CommentDto> findAll() {
        var cmts = commentRepo.findAll();
        List<CommentDto> comments = cmts.stream()
                .filter(comment -> !comment.isDeleted())
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .toList();
        return comments;
    }

    @Override
    public CommentDto addComment(CommentDto comment) {
        int facultyId = 1; //for now using static
        Faculty faculty = new Faculty();
        faculty.setId(facultyId);
        Comment comment1 = modelMapper.map(comment, Comment.class);
        comment1.setFaculty(faculty);
        commentRepo.save(comment1);
        return modelMapper.map(comment1, CommentDto.class);
    }

    @Override
    public CommentDto updateComment(int id, CommentDto comment) {
        Comment comment1 = commentRepo.findById(id).orElseThrow(()->new RuntimeException("Comment Not found"));
        comment1 = modelMapper.map(comment, Comment.class);
        comment1.setId(id);
        commentRepo.save(comment1);
        return modelMapper.map(comment1, CommentDto.class);
    }

    @Override
    public void deleteComment(int id) {
    Comment comment = commentRepo.findById(id)
            .orElseThrow(()->new RuntimeException("Comment not found"));
    comment.setDeleted(true);
    commentRepo.save(comment);

    }

    @Override
    public CommentDto findById(int id) {
        Comment comment = commentRepo.findById(id)
                .filter(comment1 -> !comment1.isDeleted())
                .orElseThrow(()->new RuntimeException("comment not found"));

        return modelMapper.map(comment, CommentDto.class);
    }

    @Override
    public List<CommentDto> findCommentByStudent_Id(int id) {
        List<CommentDto> comments = commentRepo.findCommentByStudent_Id(id).stream().filter(comment -> !comment.isDeleted()).map(comment -> modelMapper.map(comment, CommentDto.class)).toList();
        return comments;
    }
}
