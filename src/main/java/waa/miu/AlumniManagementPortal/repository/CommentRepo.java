package waa.miu.AlumniManagementPortal.repository;

import org.springframework.data.repository.ListCrudRepository;
import waa.miu.AlumniManagementPortal.entity.Comment;

import java.util.List;

public interface CommentRepo extends ListCrudRepository<Comment,Long> {

    List<Comment> findByStudentId(Long studentId);

    List<Comment> findByFacultyId(Long facultyId);

}
