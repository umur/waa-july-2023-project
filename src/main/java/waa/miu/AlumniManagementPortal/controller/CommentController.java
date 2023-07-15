package waa.miu.AlumniManagementPortal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import waa.miu.AlumniManagementPortal.entity.Comment;
import waa.miu.AlumniManagementPortal.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
@CrossOrigin
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment createdComment = commentService.createComment(comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getCommentById(id);
        return ResponseEntity.ok(comment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        comment.setId(id);
        Comment updatedComment = commentService.updateComment(comment);
        return ResponseEntity.ok(updatedComment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/students/{studentId}")
    public ResponseEntity<List<Comment>> getCommentsByStudentId(@PathVariable Long studentId) {
        List<Comment> comments = commentService.getCommentsByStudentId(studentId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/faculty/{facultyId}")
    public ResponseEntity<List<Comment>> getCommentsByFacultyId(@PathVariable Long facultyId) {
        List<Comment> comments = commentService.getCommentsByFacultyId(facultyId);
        return ResponseEntity.ok(comments);
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

}
