package waa.miu.AlumniManagementPortal.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.miu.AlumniManagementPortal.entity.Comment;
import waa.miu.AlumniManagementPortal.repository.CommentRepo;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;

    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }
    public Comment createComment(Comment comment) {
        return commentRepo.save(comment);
    }

    public Comment getCommentById(Long id) {
        return commentRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found with id: " + id));
    }

    public Comment updateComment(Comment comment) {
        if (!commentRepo.existsById(comment.getId())) {
            throw new EntityNotFoundException("Comment not found with id: " + comment.getId());
        }
        return commentRepo.save(comment);
    }
    public List<Comment> getAllComments(){
        return commentRepo.findAll();
    }
    public void deleteComment(Long id) {
        if (!commentRepo.existsById(id)) {
            throw new EntityNotFoundException("Comment not found with id: " + id);
        }
        commentRepo.deleteById(id);
    }

    public List<Comment> getCommentsByStudentId(Long studentId) {
        return commentRepo.findByStudentId(studentId);
    }

    public List<Comment> getCommentsByFacultyId(Long facultyId) {
        return commentRepo.findByFacultyId(facultyId);
    }



}
