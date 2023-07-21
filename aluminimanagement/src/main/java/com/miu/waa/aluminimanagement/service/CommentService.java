package com.miu.waa.aluminimanagement.service;

import com.miu.waa.aluminimanagement.model.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();
    CommentDto addComment(CommentDto comment);
    CommentDto updateComment(int id, CommentDto comment);
    void deleteComment(int id);
    CommentDto findById(int id);
    List<CommentDto> findCommentByStudent_Id(int id);

}
