package waa.miu.AlumniManagementPortal.service;

import waa.miu.AlumniManagementPortal.entity.Comment;

import java.util.List;

public interface CommentService {
    public Comment createComment(Comment comment);
    public List<Comment> getAllComments();
    public Comment getCommentById(Long id);
    public void deleteComment(Long id);
    public Comment updateComment(Comment comment);
    public List<Comment> getCommentsByStudentId(Long studentId);
    public List<Comment> getCommentsByFacultyId(Long facultyId);

}
