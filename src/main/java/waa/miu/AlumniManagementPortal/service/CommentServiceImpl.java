package waa.miu.AlumniManagementPortal.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import waa.miu.AlumniManagementPortal.entity.Comment;
import waa.miu.AlumniManagementPortal.repository.CommentRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepo commentRepo;

    public Comment createComment(Comment comment) {
        return commentRepo.save(comment);
    }

    public Comment getCommentById(Long id) {
        return commentRepo.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment with id "+id+" not found"));
    }

    public Comment updateComment(Comment comment) {
        if (!commentRepo.existsById(comment.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment with id "+comment.getId()+" not found");
        }
        return commentRepo.save(comment);
    }

    public List<Comment> getAllComments(){
        return commentRepo.findAll();
    }

    public void deleteComment(Long id) {
        if (!commentRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment with id "+id+" not found");
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
